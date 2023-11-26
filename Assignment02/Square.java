/**
 * The Square class is a subclass of Rectangle that can get its Area and Perimeter
 * based off of the parent class (Rectangle)
 *
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 *
 */
public class Square extends Rectangle {

    /**
     * Constructor method for when the class is instantiated without parameters.
     * Initiates attributes when used.
     */
    public Square() {
        Point topLeft, bottomRight;
    }

    /**
     * Constructor method for when the class is instantiated with parameters. It uses Rectangles constructor to
     * create the Square object.
     *
     * @param theTopLeft This is an instance of the Point class that represents the
     *                   top left coordinate point of the rectangle
     * @param theLength  This is an Integer that represents the length of the square
     */
    public Square(final Point theTopLeft, final int theLength) {
        super(theTopLeft, new Point(theTopLeft.getX() + theLength, theTopLeft.getY() - theLength));
    }


    /**
     * This is a getter method that will get the type of Shape.
     *
     * @return  returns a String "Rectangle"
     */
    public String getType() {
        return "Square";
    }

}
