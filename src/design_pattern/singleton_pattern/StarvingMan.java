package design_pattern.singleton_pattern;

/**
 * description Starving man mode singleton, not lazy
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class StarvingMan {

    private static StarvingMan instance = new StarvingMan();

    private StarvingMan() {

    }

    public static StarvingMan getInstance() {
        return instance;
    }

    public void whisper() {
        System.out.println("this is a singleton: " + this + ".");
    }
}
