package onmyoji;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * description Test
 * author Melo Chan
 * date 2017/5/15
 * version 0.0.0.1
 */
@SuppressWarnings("SameParameterValue")
public class Test {

    private static final Statistics FOOL_TARGET = new Statistics("Fool target").setHp(98500).setDef(0);

    public static void main(String[] args) {
        List<Statistics> statisticsList = new ArrayList<>();

        Statistics myBird = new Statistics("My bird").setAtt(8069).setCri(0.98).setCriDmg(1.86);
        Statistics myBirdOb = new Statistics("My bird ob").setAtt(7978).setCri(1).setCriDmg(1.74);
        Statistics yjBird = new Statistics("Yj's bird").setAtt(7839).setCri(1).setCriDmg(1.83);
        statisticsList.add(myBird);
        statisticsList.add(myBirdOb);
        statisticsList.add(yjBird);

        statisticsList.forEach(statistics -> System.out.println(statistics.getAlias() +
                " \tatt: " + (int) statistics.getAtt() +
                ", cri: " + (int) (statistics.getCri() * 100) +
                "%, cri-d: " + new BigDecimal(statistics.getCriDmg()).setScale(2, RoundingMode.HALF_UP).doubleValue() +
                " --> " + (int) (Statistics.getDamageEx(statistics) * Statistics.getHurtRateEx(FOOL_TARGET) + Spec.ZHENNV_SPEC.damage(statistics, FOOL_TARGET))));

        System.out.println("");

        statisticsList.forEach(statistics -> System.out.println(statistics.getAlias() +
                " \tatt: " + (int) statistics.getAtt() +
                ", cri: " + (int) (statistics.getCri() * 100) +
                "%, cri-d: " + new BigDecimal(statistics.getCriDmg()).setScale(2, RoundingMode.HALF_UP).doubleValue() +
                " --> " + (int) ((Statistics.getDamageEx(statistics) + Spec.POSHI_SPEC.damage(statistics)) * Statistics.getHurtRateEx(FOOL_TARGET))));
    }
}
