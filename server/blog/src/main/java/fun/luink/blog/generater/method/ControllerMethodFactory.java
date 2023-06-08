package fun.luink.blog.generater.method;

import org.springframework.javapoet.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ControllerMethodFactory implements MethodSpecFactory{

    private final Class<?> entityClass;
    private final String parameter;
    String modelName;
    ClassName serviceMark;

    String capitalize;

    String serviceName;

    public ControllerMethodFactory(String modelName, ClassName serviceMark, Class<?> entityClass){
        this.modelName = modelName;
        this.serviceMark = serviceMark;
        this.serviceName = StringUtils.uncapitalize(serviceMark.simpleName());
        this.capitalize = StringUtils.capitalize(modelName);
        this.entityClass = entityClass;
        this.parameter = StringUtils.uncapitalize(entityClass.getSimpleName());
    }

    @Override
    public MethodSpec generateGetMethod() {
        String name = "get"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addAnnotation(AnnotationSpec.builder(GetMapping.class)
                        .addMember("value","$S","/" + name + "/{id}")
                        .build())
                .addModifiers(Modifier.PUBLIC)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(String.class,"id")
                        .addAnnotation(AnnotationSpec.builder(PathVariable.class)
                                .addMember("value","$S","id")
                                .build())
                        .build())
                .addStatement("return $L.$L(id)",serviceName,name)
                .build();
    }

    @Override
    public MethodSpec generateListMethod() {
        String name = "get"+capitalize+"List";
        return MethodSpec.methodBuilder(name)
                .addAnnotation(AnnotationSpec.builder(PostMapping.class)
                        .addMember("value","$S","/" + name)
                        .build())
                .addModifiers(Modifier.PUBLIC)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter)
                        .build())
                .addStatement("return $L.$L($L)",serviceName,name,parameter)
                .build();
    }

    @Override
    public MethodSpec generateAddMethod() {
        String name = "add"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addAnnotation(AnnotationSpec.builder(PutMapping.class)
                        .addMember("value","$S","/" + name)
                        .build())
                .addModifiers(Modifier.PUBLIC)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter)
                        .build())
                .addStatement("return $L.$L($L)",serviceName,name,parameter)
                .build();
    }

    @Override
    public MethodSpec generateUpdateMethod() {
        String name = "update"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addAnnotation(AnnotationSpec.builder(PutMapping.class)
                        .addMember("value","$S","/" + name)
                        .build())
                .addModifiers(Modifier.PUBLIC)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter)
                        .build())
                .addStatement("return $L.$L($L)",serviceName,name,parameter)
                .build();
    }

    @Override
    public MethodSpec generateDelMethod() {
        String name = "del"+capitalize;

        return MethodSpec.methodBuilder(name)
                .addAnnotation(AnnotationSpec.builder(DeleteMapping.class)
                        .addMember("value","$S","/" + name)
                        .build())
                .addModifiers(Modifier.PUBLIC)
                .returns(resultObj)
                .addParameter(ParameterizedTypeName.get(List.class,String.class),parameter)
                .addStatement("return $L.$L($L)",serviceName,name,parameter)
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
