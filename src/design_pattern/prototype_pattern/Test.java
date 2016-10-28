package design_pattern.prototype_pattern;

/**
 * description Test for prototype pattern
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
public class Test {

    public static void main(String[] args) {
        Direction west = DirCache.getDirection(0);
        testDirection(west);

        testDirection(DirCache.getDirection(1));
        testDirection(DirCache.getDirection(2));
        testDirection(DirCache.getDirection(3));
        testDirection(DirCache.getDirection(4));

        if (west != null) west.setId(-1);
        testDirection(west);
        testDirection(DirCache.getDirection(0));
    }

    private static void testDirection(Direction direction) {
        if (direction != null) System.out.println(direction.getName() + ": " + direction.getId());
        else System.out.println("invalid direction!");
    }
}
