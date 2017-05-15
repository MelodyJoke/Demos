package algorithms;

/**
 * description Demos for Yinyangshi
 * author Melo Chan
 * date 2017/1/23
 * version 0.0.0.1
 */
@SuppressWarnings("SameParameterValue")
public class ForYys {

    public static void main(String[] args) {
        System.out.println(damageExpected(7978, 1.00, 1.74, true, 98500));
        System.out.println(damageExpected(7839, 1.00, 1.83, true, 98500));
        System.out.println(damageExpected(7573, 1.00, 1.77, true, 98500));
        System.out.println(damageExpected(8069, 0.98, 1.86, true, 98500));
        System.out.println(damageExpected(7500, 0.90, 2.50, true, 98500));
    }

    private static double damageExpected(double attack, double critical, double criticalDamage, boolean specEff, double aimHP) {
        double withOutSpecEff = damageWithoutSpecEff(attack, critical, criticalDamage);

        if (!specEff) return withOutSpecEff;

        if (aimHP <= 0 || aimHP * 0.1 >= attack * 1.2) return withOutSpecEff + attack * 1.2 * 0.4 * critical;

        return withOutSpecEff + aimHP * 0.1 * 0.4 * critical;
    }

    private static double damageWithoutSpecEff(double attack, double critical, double criticalDamage) {
        return attack * (1 - critical) + attack * critical * criticalDamage;
    }
}
