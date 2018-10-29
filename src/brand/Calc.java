package brand;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class Calc {

    private Calc() {

    }

    public static double damage(double attack, double critical, double criticalDamage) {
        return attack * (1 - critical) + attack * critical * criticalDamage;
    }

    public static double zhenNv(double attack, double critical, double criticalDamage, double aimHP) {
        double withOutSpecEff = damage(attack, critical, criticalDamage);

        if (aimHP <= 0 || aimHP * 0.1 >= attack * 1.2) return withOutSpecEff + attack * 1.2 * 0.4 * critical;

        return withOutSpecEff + aimHP * 0.1 * 0.4 * critical;
    }

    public static double poShi(double attack, double critical, double criticalDamage) {
        return damage(attack, critical, criticalDamage) * 1.4;
    }
}
