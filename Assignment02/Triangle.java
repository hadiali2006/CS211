/**
 * The Triangle class is a subclass of AbstractShape that can get its Area and Perimeter
 * based off of its given points when its instantiated
 *
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 *
 */
public class Triangle extends AbstractShape {

    /**
     * An instance of the Point class that represents the first point of the triangle
     */
    private Point myPoint1;

    /**
     * An instance of the Point class that represents the second point of the triangle
     */
    private Point myPoint2;

    /**
     * An instance of the Point class that represents the third point of the triangle
     */
    private Point myPoint3;

    /**
     * Constructor method for when the class is instantiated without parameters
     */
    public Triangle() {}

    /**
     * Constructor method for when the class is instantiated with parameters. It sets the
     * three attributes to myPoint1, myPoint2, and myPoint3 respectively.
     *
     * @param thePoint1 An instance of the Point class that represents the first point of the triangle
     * @param thePoint2 An instance of the Point class that represents the second point of the triangle
     * @param thePoint3 An instance of the Point class that represents the third point of the triangle
     */
    public Triangle(final Point thePoint1, final Point thePoint2, final Point thePoint3) {
        myPoint1 = thePoint1;
        myPoint2 = thePoint2;
        myPoint3 = thePoint3;
    }

    /**
     * This method is an override for the toString in the object class
     *
     * @return  returns a statement that lists the triangles type, first point, second point, and third point
     */
    public String toString() {
        return "{Type=" + getType() + ", Point1=" + myPoint1.toString()
                + ", Point2=" + myPoint2.toString() + ", Point3=" + myPoint3.toString() + "}";
    }

    /**
     * This is a getter method that will get the type of Shape.
     *
     * @return  returns a String "Triangle"
     */
    public String getType() {
        return "Triangle";
    }

    /**
     * This is a getter method that will get the perimeter of the triangle.
     *
     * @return  returns a double that represents the perimeter of the triangle
     */
    public double getPerimeter() {
        double[] sides = getSides();
        return sides[0] + sides[1] + sides[2];
    }

    /**
     * This is a getter method that will get the perimeter of the triangle. It solves for area by
     * using Herons Formula.
     *
     * @return  returns a double that represents the perimeter of the triangle
     */
    public double getArea() {
        double[] sides = getSides();
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * This is a helper getter method that will get the different sides of the triangle and put them
     * into an array of three doubles.
     *
     * @return  returns an array of doubles that represents the three sides of the triangle
     */
    private double[] getSides() {
        double[] sides = new double[3];
        sides[0]= Point.calculateDistance(myPoint1,myPoint2);
        sides[1]= Point.calculateDistance(myPoint1,myPoint3);
        sides[2]= Point.calculateDistance(myPoint2,myPoint3);
        return sides;
    }
}
