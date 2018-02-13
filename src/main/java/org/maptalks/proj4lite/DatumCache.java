package org.maptalks.proj4lite;

import java.util.HashMap;
import java.util.Map;
import org.maptalks.proj4lite.datum.BD09LL;
import org.maptalks.proj4lite.datum.CGCS2000;
import org.maptalks.proj4lite.datum.Datum;
import org.maptalks.proj4lite.datum.GCJ02;
import org.maptalks.proj4lite.datum.WGS84;

class DatumCache {

    private static Map<String, Datum> cache = new HashMap<String, Datum>();

    static {
        Datum wgs84 = new WGS84();
        Datum gcj02 = new GCJ02();
        Datum bd09ll = new BD09LL();
        Datum cgcs2000 = new CGCS2000();
        cache.put("wgs84", wgs84);
        cache.put("gcj02", gcj02);
        cache.put("bd09", bd09ll);
        cache.put("cgcs2000", cgcs2000);
    }

    public static Datum get(String name) throws Proj4Exception {
        if (name == null || name.trim().length() == 0) {
            return cache.get("wgs84");
        }
        name = name.toLowerCase();
        if (cache.containsKey(name)) {
            return cache.get(name);
        } else {
            throw new Proj4Exception(String.format("No such datum: %s", name));
        }
    }

}
