package design_pattern.builder_pattern;

/**
 * description Test for builder pattern
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
public class Test {

    public static void main(String[] args) {
        Meal.Builder builder = new Meal.Builder();

        Meal fastSet = builder.prepareFastSet();
        Meal chickenSet = builder.prepareChickenSet();

        System.out.println("FastSet:");
        fastSet.showItems();
        System.out.println("total: " + fastSet.getCost() + " cents.\n");

        System.out.println("ChickenSet:");
        chickenSet.showItems();
        System.out.println("total: " + chickenSet.getCost() + " cents.\n");
    }
}
