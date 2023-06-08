package fun.luink.blog.generater;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import fun.luink.blog.generater.method.ControllerMethodFactory;
import fun.luink.blog.generater.method.MethodSpecFactory;
import fun.luink.blog.generater.method.ServiceImplMethodFactory;
import fun.luink.blog.generater.method.ServiceMethodFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.javapoet.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 基于javapoet的代码生成器
 *
 * @author luink
 * @apiNote 根据实体类生成对应的controller，service，repository，而不是根据传统的关系型数据库表
 * 由于MongoDB特色：不需要一开始先建表（隐式建库建表），实例化对象可以直接存入MongoDB，
 */
public class CodeGenerater {

    private static final Log log = LogFactory.get();

    private static final Scanner scanner = new Scanner(System.in);

    //目标包位置
    private static String targetPackage;

    //根据实体类全类名反射class对象
    private static Class<?> entityClass;

    //生成模块全类名
    private static String fullName;

    //生成模块名（区别于类名因为可能类和模块名不同）
    private static String modelName;

    //用于类和方法的首字母大写
    private static String symbolName;

    //类名
    private static String entityName;

    //用于方法参数的实例的小驼峰
    private static String uncapitalize;

    /**
     * 未创建类时，ClassName相当于类的占位
     */
    private static ClassName repositoryMark;
    private static ClassName serviceMark;
    private static ClassName implMark;
    private static ClassName controllerMark;

    //输出文件位置（包由包名决定）
    private static File file;


    public static void main(String[] args) {
        try {
            initGenerater();
            genController();
            genService();
            genServiceImpl();
            genRepository();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static void initGenerater() throws ClassNotFoundException {

        System.out.print("请输入目标生成包名:");
        targetPackage = scanner.next();

        System.out.print("请输入实体全类名:");
        fullName = scanner.next();

        System.out.print("请输入模块名:");
        modelName = scanner.next();
        targetPackage = targetPackage + "." + modelName;

        //获取实体类class对象
        entityClass = Class.forName(fullName);
        //用于类和方法的首字母大写
        symbolName = StringUtils.capitalize(modelName);
        //类名
        entityName = StringUtils.unqualify(fullName);
        //用于参数的对象的小驼峰
        uncapitalize = StringUtils.uncapitalize(entityName);

        controllerMark = ClassName.get(targetPackage+".controller", symbolName + "Controller");
        repositoryMark = ClassName.get(targetPackage+".repository", symbolName + "Repository");
        serviceMark = ClassName.get(targetPackage+".service", symbolName + "Service");
        implMark = ClassName.get(targetPackage+".service.impl", symbolName + "ServiceImpl");

        file = new File("src/main/java/");


    }

    static void genController() throws IOException {
        //创建方法（MethodSpec）工厂
        MethodSpecFactory methodSpecFactory = new ControllerMethodFactory(modelName, serviceMark, entityClass);

        //创建类
        TypeSpec typeSpec = TypeSpec.classBuilder(controllerMark)
                .addAnnotation(AnnotationSpec.builder(RestController.class).build())//添加类注解
                .addAnnotation(AnnotationSpec.builder(RequestMapping.class).addMember("value", "$S", "/" + uncapitalize).build())//添加类权限
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec.builder(serviceMark, StringUtils.uncapitalize(serviceMark.simpleName()))
                        .addAnnotation(Autowired.class).build())
                .addMethods(methodSpecFactory.generateAll()).build();

        JavaFile javaFile = JavaFile.builder(controllerMark.packageName(), typeSpec)
                .build();
        javaFile.writeTo(file);
    }

    static void genService() throws IOException {
        //创建方法（MethodSpec）工厂
        MethodSpecFactory methodSpecFactory = new ServiceMethodFactory(modelName, repositoryMark, entityClass);
        //创建接口
        TypeSpec typeSpec = TypeSpec.interfaceBuilder(serviceMark)
                .addModifiers(Modifier.PUBLIC) //添加类权限
                .addMethods(methodSpecFactory.generateAll()).build();

        JavaFile javaFile = JavaFile.builder(serviceMark.packageName(), typeSpec)
                .build();
        javaFile.writeTo(file);
    }

    static void genServiceImpl() throws IOException {
        //创建方法（MethodSpec）工厂
        MethodSpecFactory methodSpecFactory = new ServiceImplMethodFactory(modelName, repositoryMark, entityClass);

        //创建类
        TypeSpec typeSpec = TypeSpec.classBuilder(implMark)
                .addSuperinterface(serviceMark)
                .addAnnotation(AnnotationSpec.builder(Service.class).build())//添加类注解
                .addModifiers(Modifier.PUBLIC)//添加类权限
                .addField(FieldSpec.builder(repositoryMark, StringUtils.uncapitalize(repositoryMark.simpleName()))
                        .addAnnotation(Autowired.class)
                        .build())//添加属性和注入
                .addMethods(methodSpecFactory.generateAll()).build();

        JavaFile javaFile = JavaFile.builder(implMark.packageName(), typeSpec)
                .build();
        javaFile.writeTo(file);
    }

    static void genRepository() throws IOException {
        ClassName mongoRepository = ClassName.get(MongoRepository.class);
        ClassName entity = ClassName.get(entityClass);
        ClassName string = ClassName.get(String.class);

        TypeSpec typeSpec = TypeSpec.interfaceBuilder(repositoryMark)
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(mongoRepository, entity, string))
                .build();

        JavaFile javaFile = JavaFile.builder(repositoryMark.packageName(), typeSpec).build();
        javaFile.writeTo(file);
    }
}
