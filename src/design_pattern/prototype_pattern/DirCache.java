package design_pattern.prototype_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * description Cache of {@link Direction}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class DirCache {

    private static Map<Integer, Direction> mCache;

    static {
        mCache = new HashMap<>();

        Direction west = new West();
        Direction north = new North();
        Direction east = new East();
        Direction south = new South();

        mCache.put(west.getId(), west);
        mCache.put(north.getId(), north);
        mCache.put(east.getId(), east);
        mCache.put(south.getId(), south);
    }

    public static Direction getDirection(int id) {
        if (mCache.containsKey(id))
            return (Direction) mCache.get(id).clone();

        return null;
    }
}
