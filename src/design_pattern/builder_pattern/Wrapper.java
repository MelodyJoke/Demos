package design_pattern.builder_pattern;

/**
 * description Wrapper a type of {@link Packing}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "packed by wrapper.";
    }
}
