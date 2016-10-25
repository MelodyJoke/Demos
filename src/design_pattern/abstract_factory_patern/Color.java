package design_pattern.abstract_factory_patern;

/**
 * description Color interface
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public interface Color {

    int TYPE_RED = 0, TYPE_GREEN = 1, TYPE_BLUE = 2;

    void fill();

    default String getType() {
        return getClass().getSimpleName();
    }
}
