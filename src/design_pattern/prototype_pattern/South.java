package design_pattern.prototype_pattern;

/**
 * description South a type of {@link Direction}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class South extends Direction {

    public South() {
        id = 3;
        name = "south";
    }

    @Override
    void ahead() {
        System.out.println("ahead south...");
    }
}
