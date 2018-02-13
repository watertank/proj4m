package org.maptalks.proj4lite;

public interface PointAdaptor<T> {
    double getX(T point);

    double getY(T point);

    void setX(T point, double x);

    void setY(T point, double y);
}
