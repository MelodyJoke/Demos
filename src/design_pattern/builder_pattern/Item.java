package design_pattern.builder_pattern;

/**
 * description Item interface
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public interface Item {

    default String getName() {
        return getClass().getSimpleName();
    }

    Packing getPacking();

    float getPrice();
}
