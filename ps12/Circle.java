//circle class from lecture notes
public class Circle implements Shape {

    public Point center;
    public double radius;

    public Circle (double x, double y, double newRadius) {
        center = new Point(x, y);
        radius = newRadius;
    }

    public void translate (double dx, double dy) {
        center.x = center.x + dx;
        center.y = center.y + dy;
    }
    
    public void flip (){
    	center.x = center.x - (2*radius);
    }

    public void scale (double factor) {
        radius = radius * factor;
    }

    public double circumference () {
        return 2 * Math.PI * radius;
    }

    public Box boundingBox () {
        return (new Box(center.x - radius,
                        center.y - radius,
                        2.0 * radius,
                        2.0 * radius));
    }
    
    public Point center(){
    	return center;
    }

    public String toString () {
        return
            "Circle:\n radius:   " + radius +
            "\n center: " + center +
            "\n " + boundingBox();
    }

    // Use code (test code)
    //
    public static void main (String[] args) {

        Circle c1 = new Circle(0.0, 0.0, 10.0);
        System.out.println(c1);
        c1.translate(5.5, 7.5);
        c1.scale(3.0);
        System.out.println(c1);
        System.out.println("Circumference is: " + c1.circumference());
    }
}
