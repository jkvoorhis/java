public class UseShape {

    public static void main (String[] args) {
        // test Cirlce class
    	Shape s1 = new Circle(0.0, 0.0, 1.0);
        s1.translate(20.0, 10.0);
        s1.scale(2.0);
        System.out.println(s1);
        translateAndScale(s1); 
        s1.flip();
        System.out.println("After flipping: \n" + s1 + "\n\n");
        
        //test rectangle class
        s1 = new Rectangle(1.0, 1.0);
        s1.translate(10.0, 10.0);
        s1.scale(2.0);
        System.out.println(s1);
        translateAndScale(s1);  
        s1.flip();
        System.out.println("After flipping: \n" + s1 + "\n\n");
        
        //test triangle class
        s1 = new Triangle(3.0, 4.0);
        s1.translate(20.0, 10.0);
        System.out.println(s1);
        s1.scale(2.0);
        System.out.println(s1);
        translateAndScale(s1);  // See below
        s1.flip();
        System.out.println("After flipping: \n" + s1);

    }
    
    //both translate (in x and y by 1) and scale (by 2) a shape 
    public static void translateAndScale (Shape s) {
        System.out.println("\nIn translateAndScale . . .");
        s.translate(1.0, 1.0);
        s.scale(2.0);
        System.out.println(s);
    }
}
