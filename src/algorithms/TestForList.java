package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * description TODO
 * author Melo Chan
 * date 2017/4/21
 * version 0.0.0.1
 */
public class TestForList {

    public static void main(String[] args) {
        Bean bean1 = new Bean(0, "hello venus", "alice");
        Bean bean3 = new Bean(0, "stellar", "minhee");

        List<Bean> beans = new ArrayList<>();
        beans.add(bean1);
        System.out.println(beans);
        System.out.println(beans.contains(bean3));
        beans.remove(bean3);
        System.out.println(beans);
    }
}

class Bean {

    int id;

    String msg;

    Object extra;

    Bean(int id, String msg, Object extra) {
        this.id = id;
        this.msg = msg;
        this.extra = extra;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Bean && id == ((Bean) obj).id;
    }
}
