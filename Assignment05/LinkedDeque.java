
/**
 * The class defines the node-based queue
 *
 * @param <Type> the generic data type
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
public class LinkedDeque<Type>
        extends LinkedQueue<Type>
        implements Deque<Type> {
    /**
     * The constructor initializes an empty queue.
     */
    public LinkedDeque() {
        super();
    }

    /**
     * This method adds a new element to the end of the deque
     *
     * @param theElement passed in data for the new element
     */
    @Override
    public void addRear(final Type theElement) {
        if (theElement == null) {
            throw new NullPointerException("deque");
        }
        if (head == null) {
            head = new Node(theElement);
        } else {
            Node current = head;
            Node newNode = new Node(theElement);
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * This method adds a new element to the front of the deque
     *
     * @param theElement passed in data for the new element
     */
    @Override
    public void addFront(final Type theElement) {
        if (theElement == null) {
            throw new NullPointerException("deque");
        }
        if(head == null) {
            head = new Node(theElement);
        } else {
            Node newNode = new Node(theElement, head);
            head = newNode;
        }
        size++;
    }

    /**
     * This method removes the last element of the deque
     *
     * @return returns the data of the removed element
     */
    @Override
    public Type removeRear() {
        if (head == null) {
            throw new EmptyCollectionException("deque");
        }
        Type removedElement;
        if(head.next == null) {
            removedElement = head.data;
            head = null;
        } else {
            Node current = head;
            Node prev = null;
            while(current.next != null) {
                prev = current;
                current = current.next;
            }
            removedElement = current.data;
            prev.next = null;
        }
        size--;
        return removedElement;
    }

    /**
     * This method removes the first element of the deque
     *
     * @return returns the data of the removed element
     */
    @Override
    public Type removeFront() {
        if (head == null) {
            throw new EmptyCollectionException("deque");
        }
        Type removedElement = head.data;
        head = head.next;
        size--;
        return removedElement;
    }

    /**
     * This method peeks at the last element of the deque
     *
     * @return returns the last element of the deque
     */
    @Override
    public Type peekRear() {
        if (head == null) {
            throw new EmptyCollectionException("deque");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * This method peeks at the last element of the deque
     *
     * @return returns the first element of the deque
     */
    @Override
    public Type peekFront() {
        if (head == null) {
            throw new EmptyCollectionException("deque");
        }
        return head.data;
    }

}
