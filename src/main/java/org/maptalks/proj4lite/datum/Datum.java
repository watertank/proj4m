package org.maptalks.proj4lite.datum;

import org.maptalks.proj4lite.PointAdaptor;

public interface Datum<T> {

    T toWGS84(T point, PointAdaptor<T> pointAdaptor);

    T fromWGS84(T point, PointAdaptor<T> pointAdaptor);

}
