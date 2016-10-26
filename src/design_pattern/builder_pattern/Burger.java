package design_pattern.builder_pattern;

/**
 * description Burger a type of {@link Item}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public abstract class Burger implements Item {

    @Override
    public Packing getPacking() {
        return new Wrapper();
    }

    @Override
    public abstract float getPrice();
}
