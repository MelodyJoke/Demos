import java.math.BigDecimal;

/**
 * description Entrance of project
 * author Melo Chan
 * date 2016/10/20
 * version 0.0.0.1
 */
public class Main {

    public static void main(String[] args) {
        // test in first installation
        //System.out.println("Hello Venus!");

        /*PuppetMaster master = new PuppetMaster();

        int coId = master.insert("insert into co (name, present) values (?, ?)", "JYP Entertainment", "JYP");
        System.out.println(coId);

        if (coId <= 0) return;

        int idolId = master.insert("insert into idol (name, nick, co, date) values (?, ?, ?, now())", "mina", "minari", coId);
        System.out.println(idolId);

        if (idolId <= 0) return;

        Map<String, Object> idol = master.get("select id as ids, name, nick, co, date_format(date, '%Y-%m-%d') date from idol where id = ?", idolId);
        if (idol != null) {
            idol.put("co", master.get("select id as ids, name, present from co where id = ?", idol.remove("co")));
        }

        System.out.println(PuppetMaster.gson.toJson(idol));*/

        System.out.println(1.0 - 0.66);

        System.out.println(BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.66)));

        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.66")));
    }
}
