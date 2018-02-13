package org.maptalks.proj4lite;

import java.util.HashMap;
import java.util.Map;
import org.maptalks.proj4lite.projection.BaiduMercator;
import org.maptalks.proj4lite.projection.LonLat;
import org.maptalks.proj4lite.projection.Projection;
import org.maptalks.proj4lite.projection.SphericalMercator;

class ProjectionCache {

    private static Map<String, Projection> cache = new HashMap<String, Projection>();

    static {
        Projection merc = new SphericalMercator();
        Projection baidu = new BaiduMercator();
        Projection longlat = new LonLat();
        cache.put("merc", merc);
        cache.put("bmerc", baidu);
        cache.put("longlat", longlat);
        cache.put("latlong", longlat);
        cache.put("lnglat", longlat);
        cache.put("latlng", longlat);
        cache.put("identity", longlat);
    }

    public static Projection get(String name) throws Proj4Exception {
        if (name == null || name.trim().length() == 0) {
            return cache.get("merc");
        }
        name = name.toLowerCase();
        if (cache.containsKey(name)) {
            return cache.get(name);
        } else {
            throw new Proj4Exception(String.format("No such projection: %s", name));
        }
    }

}
