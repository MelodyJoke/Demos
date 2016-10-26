package design_pattern.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * description Meal combination of several {@link Item}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class Meal {

    private List<Item> list;

    private Meal() {
        list = new ArrayList<>();
    }

    public Meal addItem(Item item) {
        list.add(item);

        return this;
    }

    public Meal removeItem(Item item) {
        list.remove(item);

        return this;
    }

    public void showItems() {
        for (Item item :
                list)
            System.out.println(item.getName() + " packed by " + item.getPacking().getName() + ", cost " + item.getPrice() + " cents.");
    }

    public float getCost() {
        float total = 0;

        for (Item item :
                list)
            total += item.getPrice();

        return total;
    }

    public static class Builder {

        public Meal prepareFastSet() {
            return new Meal().addItem(new VegBurger()).addItem(new Coke());
        }

        public Meal prepareChickenSet() {
            return new Meal().addItem(new ChickenBurger()).addItem(new Pepsi());
        }
    }
}
