/**
 * The class defines to sort the integer number in queue.
 *
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
public class RadixSort {
    /**
     * The number of digit queue.
     */
    public static final int TEN_DIGITS = 10;

    /**
     * The max digits in a number.
     */
    public static final int MAX_DIGITS = 4;

    /**
     * This method adds numbers (formatted to Strings) to their designated bucket based on what digit is currently passed in
     *
     * @param theDigit current digit that is compared with the corresponding digit of the numbers
     * @param theBuckets array of LinkedDeque instances representing the buckets used for sorting
     * @param theStringDeque LinkedDeque object representing a formatted version of the master LinkedDeque object
     * @return returns the array of LinkedDeque instances with the added elements to their respective bucket
     */
    private static Deque<String>[] addToBucket(int theDigit, Deque<String>[] theBuckets,
                                               LinkedDeque<String> theStringDeque) {
        LinkedQueue.Node current = theStringDeque.head;

        while (current != null) {
            String stringElement = (String) current.data;
            String elementCharAtDigit = String.valueOf(stringElement.charAt(theDigit));

            for (Integer bucketNum = 0; bucketNum < TEN_DIGITS; bucketNum++) {
                String bucketNumString = bucketNum.toString();

                if (elementCharAtDigit.equals(bucketNumString)) {
                    theBuckets[bucketNum].addFront(stringElement);
                }
            }

            current = current.next;
        }
        return theBuckets;
    }

    /**
     * This method sets a new LinkedDeque instance of Integers to the elements within the master deque
     *
     * @param theMaster the master deque
     * @return returns the new LinkedDeque instance
     */
    private static LinkedDeque<Integer> setMasterIntDeque(final Deque<Integer> theMaster) {
        LinkedDeque<Integer> masterIntDeque = new LinkedDeque<>();

        while (!theMaster.isEmpty()) {
            Integer element = theMaster.removeFront();
            masterIntDeque.addRear(element);
        }

        return masterIntDeque;
    }

    /**
     * This method sets a new LinkedDeque instance of Strings to the elements of the integer master deque
     *
     * @param theIntDeque the LinkedDeque of integers representing the master deque
     * @return returns the new LinkedDeque instance
     */
    private static LinkedDeque<String> setMasterStringDeque(final LinkedDeque<Integer> theIntDeque) {
        LinkedQueue.Node current = theIntDeque.head;
        LinkedDeque<String> masterStringDeque = new LinkedDeque<>();

        while (current != null) {
            String element = String.format("%04d", (Integer) current.data);
            masterStringDeque.addRear(element);
            current = current.next;
        }

        return masterStringDeque;
    }

    /**
     * The method sort the queue using radix sort.
     *
     * @param theMaster the queue
     */
    public static void sort(final Deque<Integer> theMaster) {
        @SuppressWarnings("unchecked")
        Deque<String>[] buckets = new LinkedDeque[TEN_DIGITS];
        for (int index = 0; index < TEN_DIGITS; index++) {
            buckets[index] = new LinkedDeque<>();
        }

        LinkedDeque<Integer> masterIntDeque = new LinkedDeque<>();
        LinkedDeque<String> masterStringDeque;

        while (!theMaster.isEmpty()) {
            Integer element = theMaster.removeFront();
            masterIntDeque.addFront(element);
        }

        LinkedQueue.Node current;
        masterStringDeque = setMasterStringDeque(masterIntDeque);

        for (int digit = MAX_DIGITS - 1; digit >= 0; digit--) {
            buckets = addToBucket(digit, buckets, masterStringDeque);

            current = masterStringDeque.head;
            while (current != null) { //remove
                for (int bucketNum = 0; bucketNum < TEN_DIGITS; bucketNum++) {
                    while (!buckets[bucketNum].isEmpty()) {
                        String stringElement = buckets[bucketNum].removeRear();
                        Integer intElement = Integer.parseInt(stringElement);

                        theMaster.addRear(intElement);
                    }
                }
                current = current.next;
            }
            masterIntDeque = setMasterIntDeque(theMaster);
            masterStringDeque = setMasterStringDeque(masterIntDeque);
        }

        while (!(masterIntDeque.isEmpty() && masterStringDeque.isEmpty())) {
            Integer element = masterIntDeque.removeFront();
            masterStringDeque.removeFront();

            theMaster.addRear(element);
        }
    }
}
