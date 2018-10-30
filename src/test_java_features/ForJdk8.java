package test_java_features;

import java.sql.Date;
import java.time.Clock;
import java.time.Instant;

@SuppressWarnings("WeakerAccess")
public final class ForJdk8 {

    /**
     * default interface method
     */
    public static void testForDefaultInterfaceMethod() {
        System.out.println("\ntest for default interface method");
        new Female() {
            @Override
            public void name() {
                System.out.println("mina");
                gender();
            }
        }.name();
    }

    /*
    lambda
     */

    /*
    lambda 函数式接口
     */

    /*
    lambda 方法与构造引用
     */

    /*
    lambda 作用域
     */

    /*
    lambda 访问局部变量
     */

    /*
    lambda 访问对象字段与静态变量
     */

    /*
    lambda 访问接口的默认方法
     */

    /**
     * Date API
     */
    public static void testForDateApi() {
        System.out.println("\ntest for date api...\nclock:");

        Clock clock = Clock.systemDefaultZone();
        System.out.println("\t" + clock.millis());

        Instant instant = clock.instant();
        System.out.println("\t" + Date.from(instant));
    }

    /*
    多重注解 annotations
     */

    /*
    Stream等
     */

    interface Female {

        void name();

        default void gender() {
            System.out.println("female");
        }
    }
}
