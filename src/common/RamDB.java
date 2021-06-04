package common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RamDB {
    public static final Map<Object, Object> CachedDB = new ConcurrentHashMap<>();

    private RamDB() {
    }
}
