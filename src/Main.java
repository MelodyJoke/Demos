/**
 * description Entrance of project
 * author Melo Chan
 * date 2016/10/20
 * version 0.0.0.1
 */
public class Main {

    public static void main(String[] args) {
        // test in first installation
        System.out.println("Hello Venus!");

        // test in 161024
        System.out.println("total: " + accumulate(100));
    }

    private static long accumulate(long origin) {
        return origin > 0 ? origin + accumulate(origin - 1) : origin;
    }
}
