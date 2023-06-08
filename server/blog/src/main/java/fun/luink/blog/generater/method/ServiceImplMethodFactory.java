package fun.luink.blog.generater.method;

import org.springframework.data.domain.Example;
import org.springframework.javapoet.ClassName;
import org.springframework.javapoet.MethodSpec;
import org.springframework.javapoet.ParameterSpec;
import org.springframework.javapoet.ParameterizedTypeName;
import org.springframework.util.StringUtils;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ServiceImplMethodFactory implements MethodSpecFactory{

    private final Class<?> entityClass;
    private final String parameter;
    String modelName;
    ClassName repositoryMark;

    String capitalize;

    String repositoryName;

    public ServiceImplMethodFactory(String modelName, ClassName repositoryMark, Class<?> entityClass){
        this.modelName = modelName;
        this.repositoryMark = repositoryMark;
        this.repositoryName = StringUtils.uncapitalize(repositoryMark.simpleName());
        this.capitalize = StringUtils.capitalize(modelName);
        this.entityClass = entityClass;
        this.parameter = StringUtils.uncapitalize(entityClass.getSimpleName());
    }

    @Override
    public MethodSpec generateGetMethod() {
        String name = "get"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(String.class,"id").build())
                .addStatement("return $T.success($L.findById($L))",resultObj,repositoryName,"id")
                .build();
    }

    @Override
    public MethodSpec generateListMethod() {
        String name = "get"+capitalize+"List";
        ClassName example = ClassName.get(Example.class);
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter)
                        .build())
                .addStatement("return $T.success($L.findAll($T.of($L)))",resultObj,repositoryName,example,parameter)
                .build();
    }

    @Override
    public MethodSpec generateAddMethod() {
        String name = "add"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter)
                        .build())
                .addStatement("$T save = $L.insert($L)",entityClass,repositoryName,parameter)
                .addStatement("return $T.success(save)",resultObj)
                .build();
    }

    @Override
    public MethodSpec generateUpdateMethod() {
        String name = "update"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter)
                        .build())
                .addStatement("$T save = $L.save($L)",entityClass,repositoryName,parameter)
                .addStatement("return $T.success(save)",resultObj)
                .build();
    }

    @Override
    public MethodSpec generateDelMethod() {
        String name = "del"+capitalize;

        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(resultObj)
                .addParameter(ParameterizedTypeName.get(List.class,String.class),"ids")
                .addStatement("$L.deleteAllById($L)",repositoryName,"ids")
                .addStatement("return $T.success()",resultObj)
                .build();
    }

    @Override
    public Iterable<MethodSpec> generateAll() {
        return new ArrayList<>(){{
            add(generateGetMethod());
            add(generateAddMethod());
            add(generateUpdateMethod());
            add(generateDelMethod());
            add(generateListMethod());
        }};
    }
}
