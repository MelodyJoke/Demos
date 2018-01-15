package algorithms;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class AnnoDemo {

    public static void main(String... args) {
        try {
            for (Method method : AnnoDemo.class.getClassLoader().loadClass("algorithms.AnnoDemo").getMethods()) {
                if (method.isAnnotationPresent(Option.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println(anno.toString());
                        }
                        Option option = method.getAnnotation(Option.class);

                        System.out.println(option.result());
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Option(description = "test for annotation", paras = {
            "para1", "params2"
    }, result = "hello venus")
    public String test() {
        return "hello venus";
    }
}

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Option {
    String description();

    String[] paras();

    String result();
}