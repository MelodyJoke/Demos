package test_java_features;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class ForJdk5 {

    /*
    自动装箱与拆箱
     */

    /*
    枚举 enum
     */

    /*
    静态导入 import static
     */

    /**
     * 可变参数 varargs
     */
    public static void testForVarargs(String... args) {
        System.out.println("\ntest for varargs...");

        if (args == null || args.length <= 0) System.out.println("empty");
        else System.out.println(Arrays.toString(args));
    }

    /**
     * 内省 introspector
     */
    public static void testForIntrospector() {
        try {
            System.out.println("\ntest for introspector...");

            Idol mina = new Idol("mina", 21, false);
            System.out.println("single property: " + new PropertyDescriptor("name", Idol.class).getReadMethod().invoke(mina));

            System.out.println("all properties:");
            PropertyDescriptor[] descriptors = Introspector.getBeanInfo(Idol.class).getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                System.out.println("\t" + descriptor.getName() + ": " + descriptor.getReadMethod().invoke(mina));
            }
        } catch (Exception ignore) {

        }
    }

    /*
    泛型 generic
     */

    /*
     for each
     */

    public static class Idol {

        private String name;

        private int age;

        private boolean male;

        public Idol() {

        }

        public Idol(String name, int age, boolean male) {
            this.name = name;
            this.age = age;
            this.male = male;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isMale() {
            return male;
        }

        public void setMale(boolean male) {
            this.male = male;
        }

        @Override
        public String toString() {
            return "Idol{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", male=" + male +
                    '}';
        }
    }
}
