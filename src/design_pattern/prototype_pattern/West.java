package design_pattern.prototype_pattern;

/**
 * description West a type of {@link Direction}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class West extends Direction {

    public West() {
        id = 0;
        name = "west";
    }

    @Override
    void ahead() {
        System.out.println("ahead west...");
    }
}
