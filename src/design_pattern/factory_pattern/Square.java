package design_pattern.factory_pattern;

/**
 * description Square, a type of {@link Shape}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("A square is drawing...");
    }
}
