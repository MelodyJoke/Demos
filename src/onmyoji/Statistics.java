package onmyoji;

import java.io.Serializable;

/**
 * description Statistics of role
 * author Melo Chan
 * date 2017/5/15
 * version 0.0.0.1
 */
@SuppressWarnings("WeakerAccess, unused, SameParameterValue")
public class Statistics implements Serializable {

    /**
     * alias
     */
    private String alias;

    /**
     * attack
     */
    private double att;

    /**
     * health point
     */
    private double hp;

    /**
     * defence
     */
    private double def;

    /**
     * speed
     */
    private double speed;

    /**
     * critical rate
     */
    private double cri;

    /**
     * critical damage addition reaction
     */
    private double criDmg = 1.5;

    /**
     * hit rate
     */
    private double hit;

    /**
     * resistance rate
     */
    private double resist;

    public Statistics(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public Statistics setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public double getAtt() {
        return att;
    }

    public Statistics setAtt(double att) {
        this.att = att;
        return this;
    }

    public double getHp() {
        return hp;
    }

    public Statistics setHp(double hp) {
        this.hp = hp;
        return this;
    }

    public double getDef() {
        return def;
    }

    public Statistics setDef(double def) {
        this.def = def;
        return this;
    }

    public double getSpeed() {
        return speed;
    }

    public Statistics setSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    public double getCri() {
        return cri;
    }

    public Statistics setCri(double cri) {
        this.cri = cri;
        return this;
    }

    public double getCriDmg() {
        return criDmg;
    }

    public Statistics setCriDmg(double criDmg) {
        this.criDmg = criDmg;
        return this;
    }

    public double getHit() {
        return hit;
    }

    public Statistics setHit(double hit) {
        this.hit = hit;
        return this;
    }

    public double getResist() {
        return resist;
    }

    public Statistics setResist(double resist) {
        this.resist = resist;
        return this;
    }

    public static double getDamageEx(Statistics statistics) {
        if (statistics == null || statistics.att < 0 || statistics.cri < 0) return -1;

        return statistics.getAtt() * (1 - statistics.getCri()) + statistics.getAtt() * statistics.getCri() * statistics.getCriDmg();
    }

    public static double getHurtRateEx(Statistics statistics) {
        if (statistics == null || statistics.def < 0) return -1;

        return 300.0 / (300 + statistics.def);
    }
}
