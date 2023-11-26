/**
 * The Rectangle class is a subclass of AbstractShape that can get its Area and Perimeter
 * based off of its given points when its instantiated
 *
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 *
 */
public class Rectangle extends AbstractShape {

    /**
     * Instance of the Point class for the top left coordinate point of the rectangle
     */
    private Point myTopLeft;

    /**
     * Instance of the Point class for the bottom right coordinate point of the rectangle
     */
    private Point myBottomRight;

    /**
     * Constructor method for when the class is instantiated without parameters
     */
    public Rectangle() {}

    /**
     * Constructor method for when the class is instantiated with parameters. It sets the
     * two attributes to myTopLeft and myBottomRight respectively
     *
     * @param theTopLeft        This is an instance of the Point class that represents the
     *                          top left coordinate point of the rectangle
     * @param theBottomRight    This is an instance of the Point class that represents the
     *                          bottom right coordinate point of the rectangle
     */
    public Rectangle(final Point theTopLeft, final Point theBottomRight) {
        myTopLeft = theTopLeft;
        myBottomRight = theBottomRight;
    }

    /**
     * This method is an override for the toString in the object class
     *
     * @return  returns a statement that lists the rectangles type, and top left point, bottom right point
     */
    public String toString() {
        return "{Type=" + getType() + ", TopLeft=" + myTopLeft.toString() + ", BottomRight=" + myBottomRight.toString() + "}";
    }

    /**
     * This is a getter method that will get the type of Shape.
     *
     * @return  returns a String "Rectangle"
     */
    public String getType() {
        return "Rectangle";
    }

    /**
     * This is a getter method that will get the perimeter of the rectangle. It solves for perimeter by adding the
     * length times 2 and width times 2.
     *
     * @return  returns the double that represents the perimeter of the rectangle
     */
    public double getPerimeter() {
        return (getLength()*2)+(getWidth()*2);
    }

    /**
     * This is a getter method that will get the area of the rectangle. It solves for perimeter by multiplying the
     * length and width.
     *
     * @return  returns a double that represents the area of the rectangle
     */
    public double getArea() {
        return getLength()*getWidth();
    }

    /**
     * This is a helper getter method that will get the length of the rectangle. It solves for the length by subtracting
     * the top left points y value and the bottom rights y value.
     *
     * @return  returns a double that represents the length of the rectangle
     */
    private double getLength() {
        return Math.abs(myTopLeft.getY()-myBottomRight.getY());
    }

    /**
     * This is a helper getter method that will get the width of the rectangle. It solves for the width by subtracting
     * the top left points x value and the bottom rights x value.
     *
     * @return   returns a double that represents the length of the rectangle
     */
    private double getWidth() {
        return Math.abs(myTopLeft.getX()-myBottomRight.getX());
    }


}
