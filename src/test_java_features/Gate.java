package test_java_features;

public class Gate {

    public static void main(String... args) {
        // for jdk 5
        ForJdk5.testForVarargs("nayeon", "jeongyeon", "momo", "sana", "jihyo", "mina", "dahyun", "chaeyoung", "tzuyu");
        ForJdk5.testForIntrospector();

        // for jdk 6

        // for jdk 7
        ForJdk7.testForSwitchString("love");
        ForJdk7.testForAutoCloseable();

        // for jdk 8
        ForJdk8.testForDefaultInterfaceMethod();
        ForJdk8.testForDateApi();
    }
}
