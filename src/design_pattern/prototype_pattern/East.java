package design_pattern.prototype_pattern;

/**
 * description East a type of {@link Direction}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class East extends Direction {

    public East() {
        id = 2;
        name = "east";
    }

    @Override
    void ahead() {
        System.out.println("ahead east...");
    }
}
