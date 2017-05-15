package onmyoji;

/**
 * description Special effects
 * author Melo Chan
 * date 2017/5/15
 * version 0.0.0.1
 */
@SuppressWarnings("WeakerAccess, unused")
public class Spec {

    public static final IndependentSpec POSHI_SPEC = statistics -> 0.4 * Statistics.getDamageEx(statistics);

    public static final RelativeSpec ZHENNV_SPEC = (from, to) -> {
        if (to.getHp() <= 0 || to.getHp() * 0.1 >= from.getAtt() * 1.2)
            return from.getAtt() * 1.2 * 0.4 * from.getCri();

        return to.getHp() * 0.1 * 0.4 * from.getCri();
    };

    public interface IndependentSpec {
        double damage(Statistics statistics);
    }

    public interface RelativeSpec {
        double damage(Statistics from, Statistics to);
    }
}
