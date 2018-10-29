package tool;

@SuppressWarnings("unused")
public class Co {

    private String id;

    private String name;

    private String present;

    public Co() {

    }

    public Co(String id, String name, String present) {
        this.id = id;
        this.name = name;
        this.present = present;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return PuppetMaster.gson.toJson(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Co && Utils.equals(id, ((Co) obj).id);
    }
}
