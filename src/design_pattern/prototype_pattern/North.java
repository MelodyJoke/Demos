package design_pattern.prototype_pattern;

/**
 * description North a type of {@link Direction}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class North extends Direction {

    public North() {
        id = 1;
        name = "north";
    }

    @Override
    void ahead() {
        System.out.println("ahead north...");
    }
}
