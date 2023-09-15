package fun.luink.blog.generater.method;

import fun.luink.blog.common.model.R;
import org.springframework.javapoet.ClassName;
import org.springframework.javapoet.MethodSpec;

public interface MethodSpecFactory {

    ClassName resultObj = ClassName.get(R.class);



    MethodSpec generateGetMethod();

    MethodSpec generateListMethod();

    MethodSpec generateAddMethod();

    MethodSpec generateUpdateMethod();

    MethodSpec generateDelMethod();

    Iterable<MethodSpec> generateAll();
}
