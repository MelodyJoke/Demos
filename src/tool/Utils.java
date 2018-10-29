package tool;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class Utils {

    public static boolean isEmpty(String src) {
        return src == null || src.isEmpty();
    }

    public static boolean equals(String left, String right) {
        return left == null && right == null || left != null && left.equals(right);
    }

    public static String checkString(String src) {
        return isEmpty(src) ? "" : src;
    }
}
