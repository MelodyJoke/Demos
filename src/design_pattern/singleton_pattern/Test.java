package design_pattern.singleton_pattern;

/**
 * description Test for singleton pattern
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 * <p>
 * 不建议使用 {@link Sluggard}，建议使用 {@link StarvingMan}
 * 只有在要明确实现 lazy loading 效果时，才会使用 {@link Registration}
 * 如果涉及到反序列化创建对象时，可以尝试使用 {@link Enum}
 * 如果有其他特殊的需求，可以考虑使用 {@link DCL}
 */
@SuppressWarnings("unused, SameParameterValue")
public class Test {

    private static void testSluggard(boolean isMultiThread) {
        if (!isMultiThread)
            for (int i = 0; i < 100; i++) Sluggard.getInstance().whisper();
        else
            for (int i = 0; i < 100; i++) new Thread(() -> Sluggard.getInstance().whisper()).start();
    }

    private static void testStarvingMan(boolean isMultiThread) {
        if (!isMultiThread)
            for (int i = 0; i < 100; i++) StarvingMan.getInstance().whisper();
        else
            for (int i = 0; i < 100; i++) new Thread(() -> StarvingMan.getInstance().whisper()).start();
    }

    private static void testDCL(boolean isMultiThread) {
        if (!isMultiThread)
            for (int i = 0; i < 100; i++) DCL.getInstance().whisper();
        else
            for (int i = 0; i < 100; i++) new Thread(() -> DCL.getInstance().whisper()).start();
    }

    private static void testRegistration(boolean isMultiThread) {
        if (!isMultiThread)
            for (int i = 0; i < 100; i++) Registration.getInstance().whisper();
        else
            for (int i = 0; i < 100; i++) new Thread(() -> Registration.getInstance().whisper()).start();
    }

    private static void testEnum(boolean isMultiThread) {
        if (!isMultiThread)
            for (int i = 0; i < 100; i++) Enum.INSTANCE.whisper();
        else
            for (int i = 0; i < 100; i++) new Thread(Enum.INSTANCE::whisper).start();
    }

    public static void main(String[] args) {
        //testSluggard(true);
        testStarvingMan(true);
        //testDCL(true);
        //testRegistration(true);
        //testEnum(true);
    }
}
