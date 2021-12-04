package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;

public class PointWithLabel extends PointWithValue{

    public PointWithLabel(int coordinateX, int coordinateY, String value) {
        super(coordinateX, coordinateY, value);
    }

    public String getLabel() {
        return super.getValue();
    }

    public int compareTo(Point that) {
        if (that instanceof PointWithLabel) {
            return this.getLabel().compareTo(((PointWithLabel) that).getLabel());
        }
        return super.compareTo(that);
    }
}
