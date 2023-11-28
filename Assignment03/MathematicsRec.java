/**
 * The MathematicsRec class feature various methods that given number(s) perform different
 * mathematical functions using only recursion.
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
class MathematicsRec {
    /**
     * The method returns a value which:
     * - Increases each of even decimal digits of n by one
     * - Decreases each of  odd decimal digits of n by one
     * @param theDecimalNumber the input decimal number (n)
     * @return the new decimal number after digit adjustments
     */
    public static long eduodd(final long theDecimalNumber) {
        if (theDecimalNumber == 0) {
            return 1;
        } else if (theDecimalNumber < 0) {
            return -eduodd(-theDecimalNumber);
        } else {
            long lastDigit = theDecimalNumber % 10;
            long remainingDigits = theDecimalNumber / 10;

            if (lastDigit % 2 == 0) {
                lastDigit += 1;
            } else {
                lastDigit -= 1;
            }

            if (remainingDigits == 0) {
                return lastDigit;
            }

            return eduodd(remainingDigits) * 10 + lastDigit;
        }
    }

    /**
     * The method accepts non-negative integer and returns a value as described below
     * @param theDecimalNumber is a non-negative decimal number (n)
     * @return the value in following way:
     * - return 1 when n = 0
     * - return sum of fibby(floor(n/4)) and fibby(floor(3n/4)) when n > 0
     */
    public static int fibby(final int theDecimalNumber) {
        if (theDecimalNumber == 0) {
            return 1;
        }

        int floorN4 = theDecimalNumber / 4;
        int floor3N4 = (3 * theDecimalNumber) / 4;

        return fibby(floorN4) + fibby(floor3N4);
    }


    /**
     * The method calls a method that prints all consecutive values of n and its fibby value
     * @param theLowerBound the lower bound (start)
     * @param theUpperBound the upper bound (end)
     */

    public static void stg(final int theLowerBound, final int theUpperBound) {
        stg(theLowerBound, theUpperBound, -1);
    }

    /**
     * The method that recursively prints all consecutive values of n and its fibby value
     * @param theCurrentNumber the current number that is recursively iterated by +1 (lower bound)
     * @param theUpperBound the upper bound (end)
     * @param thePreviousFibby the previous number from the fibby() method
     */
    private static void stg(final int theCurrentNumber, final int theUpperBound, final int thePreviousFibby) {
        if (theCurrentNumber > theUpperBound) return;

        int currentFib = fibby(theCurrentNumber);
        if (currentFib != thePreviousFibby) {
            System.out.println(theCurrentNumber + " " + currentFib);
        }

        stg(theCurrentNumber + 1, theUpperBound, currentFib);
    }
    /**
     * The method returns the median that split the array into 3 parts
     * @param theList the list of integers (a)
     * @return the median of the list of integers
     */
    public static double median3(final int[] theList) {
        return median3Helper(theList, 0, theList.length - 1);
    }

    /**
     * The method that recursively calculates the approximate median
     * @param theList the list of integers (a)
     * @param theLowerBound the lower bound (start)
     * @param theUpperBound the upper bound (end)
     * @return the median of the list of integers
     */
    private static double median3Helper(final int[] theList, final int theLowerBound, final int theUpperBound) {
        int length = theUpperBound - theLowerBound + 1;

        if (length == 1) {
            return theList[theLowerBound];
        }
        if (length == 2) {
            return (theList[theLowerBound] + theList[theUpperBound]) / 2.0;
        }

        int size = length / 3;
        int remainder = length % 3;
        int midStart, midEnd;

        if (remainder == 0) {
            midStart = theLowerBound + size;
            midEnd = theLowerBound + (2 * size) - 1;
        } else if (remainder == 1) {
            midStart = theLowerBound + size;
            midEnd = theLowerBound + size + (length - 2 * size) - 1;
        } else {
            midStart = theLowerBound + size + 1;
            midEnd = theLowerBound + 2 * size;
        }

        double median1 = median3Helper(theList, theLowerBound, midStart - 1);
        double median2 = median3Helper(theList, midStart, midEnd);
        double median3 = median3Helper(theList, midEnd + 1, theUpperBound);

        return medianOfThree(median1, median2, median3);
    }

    /**
     * The method that finds the median of three numbers
     * @param theMedian1Value value of the first median section
     * @param theMedian2Value value of the second median section
     * @param theMedian3Value value of the third median section
     * @return the median of the original list of integers
     */
    private static double medianOfThree(final double theMedian1Value, final double theMedian2Value, final double theMedian3Value) {
        double max = theMedian1Value;

        if (theMedian2Value > max) {
            max = theMedian2Value;
        }
        if (theMedian3Value > max) {
            max = theMedian3Value;
        }

        double min = theMedian1Value;
        if (theMedian2Value < min) {
            min = theMedian2Value;
        }
        if (theMedian3Value < min) {
            min = theMedian3Value;
        }

        return theMedian1Value + theMedian2Value + theMedian3Value - max - min;
    }
}