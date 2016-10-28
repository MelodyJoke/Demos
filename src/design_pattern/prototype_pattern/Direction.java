package design_pattern.prototype_pattern;

/**
 * description Direction
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public abstract class Direction implements Cloneable {

    protected int id;

    protected String name;

    abstract void ahead();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignore) {

        }

        return null;
    }
}
