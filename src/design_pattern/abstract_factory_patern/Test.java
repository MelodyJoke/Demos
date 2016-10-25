package design_pattern.abstract_factory_patern;

import design_pattern.factory_pattern.Shape;

/**
 * description Test for abstract factory pattern
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
public class Test {

    private AbstractFactory mShapeFactory, mColorFactory;

    private Test() {
        initFactories();
    }

    private void initFactories() {
        try {
            mShapeFactory = FactoryProducer.generateFactory(AbstractFactory.FAC_SHAPE);
            mColorFactory = FactoryProducer.generateFactory(AbstractFactory.FAC_COLOR);
        } catch (Exception e) {
            System.out.println("factory error: " + e.getMessage());
        }
    }

    private void testShape(int type) {
        System.out.println("shape type: " + type);
        try {
            Shape shape = mShapeFactory.generateShape(type);

            if (shape != null) {
                shape.draw();
                System.out.println(shape.getType() + "\n");
            }
        } catch (Exception e) {
            System.out.println("shape error: " + e.getMessage() + "\n");
        }
    }

    private void testColor(int type) {
        System.out.println("color type: " + type);
        try {
            Color color = mColorFactory.generateColor(type);

            if (color != null) {
                color.fill();
                System.out.println(color.getType() + "\n");
            }
        } catch (Exception e) {
            System.out.println("color error: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        test.testShape(-1);
        test.testShape(Shape.TYPE_CIRCLE);
        test.testShape(2);

        test.testColor(-1);
        test.testColor(Color.TYPE_GREEN);
        test.testColor(2);
    }
}
