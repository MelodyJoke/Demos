package design_pattern.builder_pattern;

/**
 * description Drink a type of {@link Item}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public abstract class Drink implements Item {

    @Override
    public Packing getPacking() {
        return new Bottle();
    }

    @Override
    public abstract float getPrice();
}
