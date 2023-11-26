/**
 * The AbstractShape is an abstract class which implements the Shape interface.
 * It provides prototypes for its subclasses to follow and implements a way to compare
 * the different shapes.
 *
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 *
 */
public abstract class AbstractShape implements Shape {

    /**
     * This method is the conditions in which the different Shape objects are sorted/ordered. The Shapes with
     * a larger area are sorted first. If the area is the same it will go with whichever Shape has a larger
     * perimeter. If the perimeter and area are the same it will go with whichever Shape has a type that comes
     * first lexicographically (using the string compareTo). If everything is the same, it will not sort those
     * Shapes until on condition is different.
     *
     * @param other the object to be compared.
     * @return integer result that is required for the compareTo method in the Comparable interface.
     */

    public int compareTo(Shape other) {
        if(this.getArea() > other.getArea()) {
            return 1;
        }
        if(this.getArea() == other.getArea()) {
            if (this.getPerimeter() > other.getPerimeter()) {
                return 1;
            }
            if(this.getPerimeter() == other.getPerimeter()) {
                if ((this.getType()).compareTo(other.getType()) < 0) {
                    return 1;
                }
                if(this.getType().equals(other.getType())) {
                    return 0;
                }

            }
        }
        return -1;

    }

    /**
     * abstract method that makes sure every shape has a getType method
     *
     * @return returns a String that will be the type of Shape (eg. Triangle, Square, etc)
     */
    public abstract String getType();

    /**
     * abstract method that makes sure every shape jas a getPerimeter method
     *
     * @return returns a Double that will be result of the perimeter for the shape
     */
    public abstract double getPerimeter();

    /**
     * abstract method that makes sure every shape jas a getArea method
     *
     * @return returns a Double that will be result of the area for the shape
     */
    public abstract double getArea();

}
