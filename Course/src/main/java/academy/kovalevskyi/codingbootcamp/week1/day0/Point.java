package academy.kovalevskyi.codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {

    private int coordX;
    private int coordY;

    public Point(final int coordinateX, final int coordinateY) {
        this.coordX = coordinateX;
        this.coordY = coordinateY;
    }

    public int getX() {
        return this.coordX;
    }

    public int getY() {
        return this.coordY;
    }

    public Point sum(final Point that) {
        return new Point(this.getX() + that.getX(), this.getY() + that.getY());
    }

    public Point updateX(int newX) {
        return new Point(newX, this.coordY);
    }

    public Point updateY(int newY) {
        return new Point(this.coordX, newY);
    }

    public int distanceTo(Point that) {
        int disX = this.getX() - that.getX();
        int disY = this.getY() - that.getY();
        return (disX * disX) + (disY * disY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return (this.coordX == point.getX() && this.coordY == point.getY());
    }

    @Override
    public int hashCode() {
        return this.coordX + this.coordY;
    }

    @Override
    public String toString() {
        return "Point{" + "X: " + this.getX() + "," + " Y: " + this.getY() + "}";
    }

    @Override
    public int compareTo(Point that) {
        return hashCode() - that.hashCode();
    }
}
