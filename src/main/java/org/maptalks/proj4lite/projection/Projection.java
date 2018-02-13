package org.maptalks.proj4lite.projection;

import org.maptalks.proj4lite.PointAdaptor;

public interface Projection<T> {

    T forward(T point, PointAdaptor<T> pointAdaptor);

    T inverse(T point, PointAdaptor<T> pointAdaptor);

    ProjectionType getType();

}
