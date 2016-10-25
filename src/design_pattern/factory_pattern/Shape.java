package design_pattern.factory_pattern;

/**
 * description Shape interface
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public interface Shape {

    int TYPE_CIRCLE = 0, TYPE_SQUARE = 1, TYPE_TRIANGLE = 2;

    void draw();

    default String getType() {
        return getClass().getSimpleName();
    }
}
