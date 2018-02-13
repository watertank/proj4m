package org.maptalks.proj4lite;

import java.util.concurrent.ConcurrentHashMap;

public class Global {

    private static ConcurrentHashMap<String, Proj> defs = new ConcurrentHashMap<String, Proj>();

    static {
        def("EPSG:4326", "+proj=longlat +datum=WGS84 +no_defs");
        def("WGS84", "+proj=longlat +datum=WGS84 +no_defs");
        def("EPSG:3857", "+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +wktext +no_defs");
        def("GCJ02", "+proj=longlat +datum=GCJ02");
        def("GCJ02MC", "+proj=merc +datum=GCJ02");
        def("BD09LL", "+proj=longlat +datum=BD09");
        def("BD09MC", "+proj=bmerc +datum=BD09");
        def("IDENTITY", "+proj=identity +no_defs");
    }

    private static String normalize(String name) {
        return name.toUpperCase();
    }

    static boolean has(String name) {
        String key = normalize(name);
        return defs.containsKey(key);
    }

    static Proj def(String name) {
        String key = normalize(name);
        return defs.get(key);
    }

    public static void def(String name, String code) {
        String key = normalize(name);
        if (code.startsWith("+")) {
            defs.put(key, ProjString.parse(code));
        } else {
            defs.put(key, WKTParser.parse(code));
        }
    }

}
