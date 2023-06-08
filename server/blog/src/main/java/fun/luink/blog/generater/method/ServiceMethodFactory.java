package fun.luink.blog.generater.method;

import org.springframework.javapoet.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ServiceMethodFactory implements MethodSpecFactory{

    private final Class<?> entityClass;
    private final String parameter;
    String modelName;
    ClassName repositoryMark;

    String capitalize;

    String repositoryName;

    public ServiceMethodFactory(String modelName, ClassName repositoryMark, Class<?> entityClass){
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
                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(String.class,"id").build())
                .build();
    }

    @Override
    public MethodSpec generateListMethod() {
        String name = "get"+capitalize+"List";
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter).build())
                .build();
    }

    @Override
    public MethodSpec generateAddMethod() {
        String name = "add"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter).build())
                .build();
    }

    @Override
    public MethodSpec generateUpdateMethod() {
        String name = "update"+capitalize;
        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
                .returns(resultObj)
                .addParameter(ParameterSpec.builder(entityClass,parameter).build())
                .build();
    }

    @Override
    public MethodSpec generateDelMethod() {
        String name = "del"+capitalize;

        return MethodSpec.methodBuilder(name)
                .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
                .returns(resultObj)
                .addParameter(ParameterizedTypeName.get(List.class,String.class),parameter)
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
