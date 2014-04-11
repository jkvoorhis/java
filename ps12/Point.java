// from lecture notes
public class Point {

    public double x;
    public double y;


    public Point () {
        x = 0.0;
        y = 0.0;
    }

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString () {
        return "(" + x + ", " + y + ")";
    }

}
