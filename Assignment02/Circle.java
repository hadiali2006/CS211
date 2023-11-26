/**
 * The Circle class is a subclass of AbstractShape that can get its Area and Perimeter
 * based off of its given radius when its instantiated
 *
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 *
 */
public class Circle extends AbstractShape {

    /**
     * An instance of the Point class that represents the center point of the circle
     */
    private Point myCenter;

    /**
     * An Integer the represents the radius of the circle
     */
    private int myRadius;

    /**
     * Constructor method for when the class is instantiated without parameters
     */
    public Circle() {}

    /**
     * Constructor method for when the class is instantiated with parameters. It sets the
     * two attributes to myCenter and myRadius respectively.
     *
     * @param theCenter An instance of the Point class that represents the center point of the circle
     * @param theRadius An Integer the represents the radius of the circle
     */
    public Circle(final Point theCenter, final int theRadius) {
        myCenter = theCenter;
        myRadius = theRadius;
    }

    /**
     * This method is an override for the toString in the object class
     *
     * @return  returns a statement that lists the circles type, center point, and radius
     */
    public String toString() {
        return "{Type=" + getType() + ", Center=" + myCenter.toString() + ", Radius=" + myRadius + "}";
    }

    /**
     * This is a getter method that will get the type of Shape.
     *
     * @return  returns a String "Circle"
     */
    public String getType() {
        return "Circle";
    }

    /**
     * This is a getter method that will get the perimeter/circumference of the circle.
     *
     * @return  returns a double that represents the perimeter/circumference of the circle
     */
    public double getPerimeter() {
        return 2*Math.PI*myRadius;
    }

    /**
     * This is a getter method that will get the area of the circle.
     *
     * @return  returns a double that represents the area of the circle
     */
    public double getArea() {
        return Math.PI*(myRadius*myRadius);
    }
}
