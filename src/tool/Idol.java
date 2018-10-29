package tool;

@SuppressWarnings("unused")
public class Idol {

    private String id;

    private String name;

    private String nick;

    private String co;

    private String date;

    public Idol() {

    }

    public Idol(String id, String name, String nick, String co, String date) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.co = co;
        this.date = date;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return PuppetMaster.gson.toJson(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Idol && Utils.equals(id, ((Idol) obj).id);
    }
}
