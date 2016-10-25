package design_pattern.factory_pattern;

/**
 * description Triangle, a type of {@link Shape}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("A triangle is drawing...");
    }
}
