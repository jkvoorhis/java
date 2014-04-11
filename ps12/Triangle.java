public class Triangle implements Shape {

	public Point llcorner;
	public double width;
	public double height;
	// hypotenuse value
	public double hypot;

	//constructor
	public Triangle(double neww, double newh) {
		llcorner = new Point();
		width = neww;
		height = newh;
		hypot = Math.sqrt((width * width) + (height * height));
	}

	// translate in x by dx and in y by dy
	public void translate(double dx, double dy) {
		llcorner.x = llcorner.x + dx;
		llcorner.y = llcorner.y + dy;
	}

	//scale by the factor
	public void scale(double factor) {
		width = width * factor;
		height = height * factor;
		hypot = Math.sqrt((width * width) + (height * height));
	}

	// flip of left y-axis of bounding box
	public void flip() {
		llcorner.x = llcorner.x - width;
	}

	// calc the diagonal
	public double diagonal() {
		return hypot;
	}

	// return the bounding box
	public Box boundingBox() {
		return (new Box(llcorner.x, llcorner.y, width, height));
	}

	// return the center point
	public Point center() {
		return (new Point((llcorner.x + (width / 2)),
				(llcorner.y + (height / 2))));
	}

	public String toString() {
		return "Triangle:\n width:   " + width + "\n height: " + height
				+ "\nhypotenuse: " + hypot + "\n llcorner: " + llcorner + "\n " + boundingBox();
	}
}
