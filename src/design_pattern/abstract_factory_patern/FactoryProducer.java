package design_pattern.abstract_factory_patern;

/**
 * description Factory producer to generate {@link AbstractFactory}
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class FactoryProducer {

    public static AbstractFactory generateFactory(int type) throws Exception {
        if (type < 0 || type > 1)
            throw new Exception("Invalid type of AbstractFactory, please check in FAC_SHAPE, FAC_COLOR");

        switch (type) {
            case AbstractFactory.FAC_SHAPE:
                return new ShapeFactory();

            case AbstractFactory.FAC_COLOR:
                return new ColorFactory();
        }

        return null;
    }
}
