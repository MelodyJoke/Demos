package design_pattern.singleton_pattern;

/**
 * description Sluggard mode singleton, lazy but inefficient
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class Sluggard {

    private static Sluggard instance;

    private Sluggard() {

    }

    public static synchronized Sluggard getInstance() {
        if (instance == null) instance = new Sluggard();

        return instance;
    }

    public void whisper() {
        System.out.println("this is a singleton: " + this + ".");
    }
}
