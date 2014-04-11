// Shape interface from lecture notes with addition of center() and flip()

public interface Shape {

	// Move by dx in x-direction and dy in y-direction
	// void translate (double dx, double dy);
	public abstract void translate(double dx, double dy);

	// Scale (enlarge or shrink) by a scale factor
	// void scale (double factor);
	public abstract void scale(double factor);

	// Compute the bounding box
	// Box boundingBox ();
	public abstract Box boundingBox();

	// Compute the center of a shape's bounding box
	// and return as a point
	// Point center()
	public abstract Point center();

	// Flip the shape over the y-axis of its
	// bounding box's left side
	// void flip ()
	public abstract void flip();

}