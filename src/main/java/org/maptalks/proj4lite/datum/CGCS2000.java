package org.maptalks.proj4lite.datum;

import org.maptalks.proj4lite.PointAdaptor;

public class CGCS2000<T> implements Datum<T> {

    public T toWGS84(T point, PointAdaptor<T> pointAdaptor) {
        return point;
    }

    public T fromWGS84(T point, PointAdaptor<T> pointAdaptor) {
        return point;
    }

}
