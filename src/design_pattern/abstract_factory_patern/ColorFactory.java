package design_pattern.abstract_factory_patern;

import design_pattern.factory_pattern.Shape;

/**
 * description Factory to generate {@link Color}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape generateShape(int type) throws Exception {
        throw new Exception("This factory cannot generate Shape!");
    }

    @Override
    public Color generateColor(int type) throws Exception {
        if (type < 0 || type > 2)
            throw new Exception("Invalid type of Color, please check in TYPE_RED, TYPE_GREEN, TYPE_BLUE.");

        switch (type) {
            case Color.TYPE_RED:
                return new Red();

            case Color.TYPE_GREEN:
                return new Green();

            case Color.TYPE_BLUE:
                return new Blue();
        }

        return null;
    }
}
