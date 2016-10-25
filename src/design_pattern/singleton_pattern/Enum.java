package design_pattern.singleton_pattern;

/**
 * description Enum mode singleton, absolutely safe but not lazy
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public enum Enum {

    INSTANCE;

    public void whisper() {
        System.out.println("this is a singleton: " + this + ".");
    }
}
