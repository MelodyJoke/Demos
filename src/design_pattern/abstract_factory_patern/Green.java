package design_pattern.abstract_factory_patern;

/**
 * description Green a type of {@link Color}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("The color green is filling...");
    }
}
