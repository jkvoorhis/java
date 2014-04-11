//retangle class from lecture notes
public class Rectangle implements Shape {

    public Point llcorner;
    public double width;
    public double height;

    public Rectangle (double neww, double newh) {
        llcorner = new Point();
        width = neww;
        height = newh;
    }

    public void translate (double dx, double dy) {
        llcorner.x = llcorner.x + dx;
        llcorner.y = llcorner.y + dy;
    }

    public void scale (double factor) {
        width = width * factor;
        height = height * factor;
    }
    
    public void flip (){
    	llcorner.x = llcorner.x - width;
    }

    public double diagonal () {
        return Math.sqrt((width * width) + (height * height));
    }

    public Box boundingBox () {
        return (new Box(llcorner.x, llcorner.y, width, height));
    }
    
    public Point center(){
    	return (new Point((llcorner.x + (width/2)), (llcorner.y + (height/2))));
    }

    public String toString () {
        return
            "Rectangle:\n width:   " + width +
            "\n height: " + height +
            "\n llcorner: " + llcorner +
            "\n " + boundingBox();
    }

    // Use code (test code)
    //
    public static void main (String[] args) {
        Rectangle r1 = new Rectangle(10.0, 20.0);
        System.out.println(r1);
        r1.translate(5.0, 6.0);
        r1.scale(2.0);
        System.out.println(r1);
        System.out.println("Diagonal is: " + r1.diagonal());
    }
}

