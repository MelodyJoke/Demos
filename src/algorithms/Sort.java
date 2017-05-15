package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * description TODO
 * author Melo Chan
 * date 2017/4/25
 * version 0.0.0.1
 */
public class Sort {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(6);
        integers.add(1);
        integers.add(4);
        integers.add(8);
        integers.add(5);
        integers.add(7);

        System.out.println(integers);

        bubble(integers);

        System.out.println(integers);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable> void bubble(List<T> source) {
        if (source == null || source.isEmpty()) return;

        for (int i = source.size() - 1; i > 0; i--) {
            boolean shut = true;
            for (int j = 0; j < i; j++) {
                if (source.get(j + 1).compareTo(source.get(j)) < 0) {
                    source.add(j, source.remove(j + 1));
                    shut = false;
                }
            }

            if (shut) break;
        }
    }
}
