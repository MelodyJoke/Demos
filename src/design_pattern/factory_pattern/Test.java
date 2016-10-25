package design_pattern.factory_pattern;

/**
 * description Test for factory pattern
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
public class Test {

    private ShapeFactory mFactory;

    private Test() {
        mFactory = new ShapeFactory();
    }

    private void test(int type) {
        System.out.println("type: " + type);
        try {
            Shape shape = mFactory.generate(type);

            if (shape != null) {
                shape.draw();
                System.out.println(shape.getType() + "\n");
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        test.test(-1);
        test.test(Shape.TYPE_CIRCLE);
        test.test(Shape.TYPE_SQUARE);
        test.test(2);
        test.test(3);
    }
}
