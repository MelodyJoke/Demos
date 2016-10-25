package design_pattern.factory_pattern;

/**
 * description Factory to generate {@link Shape}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess, Duplicates")
public class ShapeFactory {

    public Shape generate(int type) throws Exception {
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
}
