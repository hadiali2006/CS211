/**
 * The class represents for the circular sorted linked list
 *
 * @param <Type> the generic data type
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
public class SortedList<Type extends Comparable<? super Type>>
        extends AbstractList<Type>
        implements List<Type> {


    /**
     * The constructor for the circular sorted linked list.
     */
    public SortedList() {
        super();
    }

    /**
     * Checks if the linked list contains a node with a specified value.
     *
     * @param theValue the value that is used to check the linked list
     * @return returns true if there is a node with the specified value and returns false if no node contains the specified value.
     */
    @Override
    public boolean contains(final Type theValue) {
        return getIndex(theValue) >= 0;
    }

    /**
     * Inserts a new ListNode at the end/tail of the linked list.
     *
     * @param theValue the value is assigned to the new ListNode
     */
    @Override
    public void insert(final Type theValue) {
        if (theValue == null) {
            throw new NullPointerException("The value could not be null");
        }
        ListNode<Type> newNode = new ListNode<>(theValue);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        }

        ListNode<Type> prevNode = null;
        ListNode<Type> currentNode = tail.next;

        do {
            if (theValue.compareTo(currentNode.data) < 0) {
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != tail.next);

        newNode.next = currentNode;
        if (prevNode != null) {
            prevNode.next = newNode;
        } else {
            tail.next = newNode;
        }

        if (theValue.compareTo(tail.data) > 0) {
            tail = newNode;
        }

        size++;
    }

    /**
     * Clears the linked list.
     */
    @Override
    public void clear() {
        if (tail == null) {
            return;
        }
        tail = null;
        size = 0;
    }

    /**
     * Removes the first node from the linked list that contains a specified value.
     *
     * @param theValue the value is searched for and removed from the linked list
     * @return returns the value parameter that is passed in (we don't want to lose connection to the removed item) or returns null if the value is not found within the linked list.
     */
    @Override
    public Type remove(final Type theValue) {
        if (theValue == null) {
            throw new NullPointerException("The value could not be null");
        }
        if (tail == null) {
            return null;
        }
        if (tail.next == tail) {
            if (tail.data == theValue) {
                Type removedValue = tail.data;
                tail = null;
                size--;
                return removedValue;
            }
            return null;
        }

        ListNode<Type> currentNode = tail.next;
        ListNode<Type> prevNode = tail;

        while (currentNode != tail) {
            if (currentNode.data.equals(theValue)) {
                prevNode.next = currentNode.next;
                if (currentNode == tail.next) {
                    tail = prevNode;
                }
                size--;
                return theValue;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (tail.data == theValue) {
            prevNode.next = tail.next;
            tail = prevNode;
            size--;
            return theValue;
        }

        return null;
    }

    /**
     * Removes a value in the list given an index.
     *
     * @param theIndex the index of the ListNode within the linked list
     * @return returns the data attribute of the ListNode or null if the list is empty
     */
    @Override
    public Type removeAtIndex(final int theIndex) {
        if (theIndex < 0 || theIndex >= getSize()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (tail == null) {
            return null;
        }

        ListNode<Type> currentNode = tail.next;

        for (int i = 0; i < theIndex - 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
        return get(theIndex);
    }

    /**
     * Throws UnsupportedOperationException as the SortedList does not want to mess up the order of the values within the linked list.
     *
     * @param theIndex the index of the ListNode within the linked list
     * @param theValue the value that is assigned to the new ListNode that replaces the original ListNode
     */
    @Override
    public void set(final int theIndex, final Type theValue) {
        throw new UnsupportedOperationException("The SortedList does not support set method");
    }

    /**
     * Gets the data of the ListNode of a given index
     *
     * @param theIndex the index of the ListNode within the linked list
     * @return returns the data attribute of the ListNode or returns null if the list is empty
     */
    @Override
    public Type get(final int theIndex) {
        if (theIndex < 0 || theIndex >= getSize()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (tail == null) {
            return null;
        }
        if (theIndex < getSize() - 1) {
            ListNode<Type> currentNode = tail.next;
            for (int i = 0; i < theIndex; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.data;

        }
        return tail.data;
    }
}
