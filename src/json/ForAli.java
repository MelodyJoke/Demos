package json;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

public class ForAli {

    public static void main(String... args) {
        /*Bean mina = new Bean(123131111, "mina", 12, Gender.FEMALE, null);
        mina.inner = mina.new Inner("hello");
        System.out.println(JSON.toJSONString(mina));
        System.out.println(JSON.parseObject("{\"age\":12,\"gender\":\"FEMALE\",\"id\":123131111,\"inner\":{\"title\":\"hello\"},\"name\":\"mina\"}", Bean.class));*/

        /*System.out.println(checkString(null));
        System.out.println(checkString(""));
        System.out.println(checkString("venus"));

        System.out.println(checkString(null, "hello"));
        System.out.println(checkString("", "hello"));
        System.out.println(checkString("venus", "hello"));

        Alice alice = new Alice(170, true, "unknown");

        Checker<Alice> checker = src -> src.height >= 170 && src.slim;

        Extractor<Alice> extractor = src -> src.manager;

        System.out.println(checkString(alice, "hello venus", null, null));
        System.out.println(checkString(alice, "hello venus", checker, null));
        checkString(alice, "hello venus", null, extractor);
        checkString(alice, "hello venus", checker, extractor);*/

        //System.out.println(new BigDecimal(".0").doubleValue());

        int a = 0;

        a++;
        a++;
        a++;

        assert a < 0;

        System.out.println(a);
    }

    public static String checkString(Object src) {
        return checkString(src, "");
    }

    public static String checkString(Object src, String defaultString) {
        return checkString(src, defaultString, null, null);
    }

    public static <T> String checkString(T src, String defaultString, Checker<T> checker, Extractor<T> extractor) {
        if (checker == null) {
            if (src == null) {
                if (extractor == null) return defaultString;

                return extractor.extract(null);
            }

            if (extractor == null) {
                String srcString = String.valueOf(src);

                if (srcString.isEmpty()) return defaultString;

                return srcString;
            }

            return extractor.extract(src);
        }

        if (!checker.check(src)) return defaultString;

        if (extractor == null) return String.valueOf(src);

        return extractor.extract(src);
    }

    public interface Checker<T> {

        boolean check(T src);
    }

    public interface Extractor<T> {

        String extract(T src);
    }

    static class Alice {

        int height;

        boolean slim;

        String manager;

        public Alice(int height, boolean slim, String manager) {
            this.height = height;
            this.slim = slim;
            this.manager = manager;
        }

        @Override
        public String toString() {
            return "Alice{" +
                    "height=" + height +
                    ", slim=" + slim +
                    ", manager='" + manager + '\'' +
                    '}';
        }
    }
}

