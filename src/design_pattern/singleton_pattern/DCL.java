package design_pattern.singleton_pattern;

/**
 * description DCL (double check locking) mode singleton, lazy and fast
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class DCL {

    private volatile static DCL instance;

    public static DCL getInstance() {
        if (instance == null)
            synchronized (DCL.class) {
                if (instance == null)
                    instance = new DCL();
            }

        return instance;
    }

    public void whisper() {
        System.out.println("this is a singleton: " + this + ".");
    }
}
