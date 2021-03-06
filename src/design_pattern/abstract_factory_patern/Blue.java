package design_pattern.abstract_factory_patern;

/**
 * description Blue a type of {@link Color}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("The color blue is filling...");
    }
}
