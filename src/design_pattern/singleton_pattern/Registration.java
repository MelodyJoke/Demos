package design_pattern.singleton_pattern;

/**
 * description Registration mode singleton, lazy and fast
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class Registration {

    private Registration() {

    }

    private static class Holder {
        private static final Registration instance = new Registration();
    }

    public static Registration getInstance() {
        return Holder.instance;
    }

    public void whisper() {
        System.out.println("this is a singleton: " + this + ".");
    }
}
