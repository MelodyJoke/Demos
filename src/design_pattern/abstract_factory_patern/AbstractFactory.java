package design_pattern.abstract_factory_patern;

import design_pattern.factory_pattern.Shape;

/**
 * description Abstract factory to generate factories
 * author Melo Chan
 * date 2016/10/25
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public abstract class AbstractFactory {

    public static final int FAC_SHAPE = 0, FAC_COLOR = 1;

    public abstract Shape generateShape(int type) throws Exception;

    public abstract Color generateColor(int type) throws Exception;
}
