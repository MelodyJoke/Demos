package design_pattern.abstract_factory_patern;

import design_pattern.factory_pattern.Circle;
import design_pattern.factory_pattern.Shape;
import design_pattern.factory_pattern.Square;
import design_pattern.factory_pattern.Triangle;

/**
 * description Factory to generate {@link Shape}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, Duplicates, WeakerAccess")
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape generateShape(int type) throws Exception {
        if (type < 0 || type > 2)
            throw new Exception("Invalid type of Shape, please check in TYPE_CIRCLE, TYPE_SQUARE, TYPE_TRIANGLE.");

        switch (type) {
            case Shape.TYPE_CIRCLE:
                return new Circle();

            case Shape.TYPE_SQUARE:
                return new Square();

            case Shape.TYPE_TRIANGLE:
                return new Triangle();
        }

        return null;
    }

    @Override
    public Color generateColor(int type) throws Exception {
        throw new Exception("This factory cannot generate Color!");
    }
}
