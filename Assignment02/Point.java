/**
 * The point describe the x and y coordinates of the 2D-point
 *
 * @author Varik Hoang <varikmp@uw.edu>
 */
public class Point
{
    /**
     * The x-coordinate of the point.
     */
    private int myX;

    /**
     * The y-coordinate of the point.
     */
    private int myY;

    /**
     * The constructor defines the point without argument
     */
    public Point()
    {
        this.myX = 0;
        this.myY = 0;
    }

    /**
     * The constructor defines the point with arguments
     *
     * @param theX the x-coordinate of the point.
     * @param theY the y-coordinate of the point.
     */
    public Point(int theX, int theY)
    {
        this.myX = theX;
        this.myY = theY;
    }

    /**
     * The method return the value of x-coordinate of the point.
     *
     * @return the value of x-coordinate of the point.
     */
    public int getX() // getter method
    {
        return myX;
    }

    /**
     * The method sets new value of x-coordinate of the point.
     *
     * @param theX the new value of x-coordinate of the point.
     */
    public void setX(int theX) // setter method
    {
        this.myX = theX;
    }

    /**
     * The method return the value of y-coordinate of the point.
     *
     * @return the value of y-coordinate of the point.
     */
    public int getY()
    {
        return myY;
    }

    /**
     * The method sets new value of y-coordinate of the point.
     *
     * @param theX the new value of y-coordinate of the point.
     */
    public void setY(int theY)
    {
        this.myY = theY;
    }

    @Override
    public String toString()
    {
        return String.format("[Point X=" + this.myX + ", Y=" + this.myY + "]");
    }

    /**
     * The method calculates the distance between two points
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between two points
     */
    public static double calculateDistance(Point p1, Point p2)
    {
        int deltaX = p1.myX - p2.myX;
        int deltaY = p1.myY - p2.myY;

        double squareOfDeltaX = Math.pow(deltaX, 2);
        double squareOfDeltaY = Math.pow(deltaY, 2);

        return Math.sqrt(squareOfDeltaX + squareOfDeltaY);
    }
}