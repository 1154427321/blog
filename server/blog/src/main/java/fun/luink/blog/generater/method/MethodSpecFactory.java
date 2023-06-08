package fun.luink.blog.generater.method;

import fun.luink.blog.common.model.ResultObj;
import org.springframework.javapoet.ClassName;
import org.springframework.javapoet.MethodSpec;
import org.springframework.javapoet.TypeSpec;

public interface MethodSpecFactory {

    ClassName resultObj = ClassName.get(ResultObj.class);



    MethodSpec generateGetMethod();

    MethodSpec generateListMethod();

    MethodSpec generateAddMethod();

    MethodSpec generateUpdateMethod();

    MethodSpec generateDelMethod();

    Iterable<MethodSpec> generateAll();
}
