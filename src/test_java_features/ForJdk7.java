package test_java_features;

@SuppressWarnings("WeakerAccess")
public class ForJdk7 {

    /**
     * switch by string
     */
    public static void testForSwitchString(String condition) {
        System.out.println("\ntest for switch string...");

        String full;

        switch (condition) {
            case "ny":
                full = "nayeon";
                break;

            case "jy":
                full = "jeongyeon";
                break;

            case "mm":
                full = "momo";
                break;

            case "sn":
                full = "sana";
                break;

            case "jh":
                full = "jihyo";
                break;

            case "dh":
                full = "dahyun";
                break;

            case "cy":
                full = "chaeyoung";
                break;

            case "ty":
                full = "tzuyu";
                break;

            default:
                full = "mina";
        }

        System.out.println(condition + ": " + full);
    }

    /*
    泛型推断
     */

    /**
     * 自动关闭 auto closeable
     */
    public static void testForAutoCloseable() {
        System.out.println("\ntest for auto closeable...");

        try (DangerousResource resource = new DangerousResource()) {
            resource.test();
            throw new Exception("test exception");
        } catch (Exception ignore) {

        }
    }

    /*
    环境信息的工具方法
    System.getJavaIoTempDir()
    System.getJavaHomeDir()
    System.getUserHomeDir()
    System.getUserDir()等
     */

    /*
    Boolean类型反转，空指针安全，参与位运算
     */

    /*
    char的equals
     */

    /*
    安全的加减乘除
     */

    /*
    Collections的增强(未实现)
     */

    /*
    数值可加下划线
     */

    /*
    支持二进制文字
     */

    /*
    简化了可变参数方法的调用
     */

    /*
    finally的简化
     */

    public static class DangerousResource implements AutoCloseable {

        public void test() {
            System.out.println("test");
        }

        @Override
        public void close() {
            System.out.println("close");
        }
    }
}
