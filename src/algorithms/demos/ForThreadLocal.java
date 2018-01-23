package algorithms.demos;

public class ForThreadLocal {

    public static void main(String... args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("hello venus");
        System.out.println(stringThreadLocal.get());

        new Thread(() -> {
            System.out.println(stringThreadLocal.get());

            stringThreadLocal.set("once twice");
            System.out.println(stringThreadLocal.get());
        }).start();
    }
}
