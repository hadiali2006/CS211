
/**
 * The shape interface provided prototypes to identify
 * the type of shape and also calculate the perimeter & area
 * @author Varik Hoang <varikmp@uw.edu>
 *
 */
public interface Shape
        extends Comparable<Shape>
{
    /**
     * The method return the type of shape
     * @return the type of shape in string format
     */
    public String getType();

    /**
     * The method returns the perimeter of the shape
     * @return the perimeter of the shape
     */
    public double getPerimeter();

    /**
     * The method returns the area of the shape
     * @return the area of the shape
     */
    public double getArea();
}