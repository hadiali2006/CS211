import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class is a unit testing for the {@link LinkedDeque}
 *
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Hadi Ali <hadi.ali@bellevuecollege.edu>
 */
public class LinkedDequeTest {

    /**
     * A generic simple LinkedDeque to test.
     */
    private LinkedDeque<Integer> myQueue;

    /**
     * The method initializes the queue before the test.
     *
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        myQueue = new LinkedDeque<>();
    }

    /**
     * Test method for{@link LinkedDeque#LinkedDeque()}.
     */
    @Test
    void testLinkedDeque() {
        assertNotNull("myQueue was not instantiated!", myQueue);
        assertEquals("myQueue should be size zero!", 0, myQueue.size());
        assertTrue("myQueue should be empty!", myQueue.isEmpty());

    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)}
     */
    @Test
    void testAddRear1() {
        myQueue.addRear(6);
        assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
        assertEquals("to string failed: expected head -> 6 instead of " + myQueue.toString(), myQueue.toString(),
                "head -> 6");
    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)}
     */
    @Test
    void testAddRear2() {
        myQueue.addRear(6);
        myQueue.addRear(-12);
        assertEquals("add failed: queue size expected 2 instead of " + myQueue.size(), 2, myQueue.size());
        assertEquals("to string failed: expected head -> 6, -12 instead of " + myQueue.toString(), myQueue.toString(),
                "head -> 6, -12");
    }

    /**
     * Test method for {@link LinkedDeque#addFront(Object)}
     */
    @Test
    void testAddFront1() {
        myQueue.addFront(6);
        assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
        assertEquals("to string failed: expected head -> 6 instead of " + myQueue.toString(), myQueue.toString(),
                "head -> 6");
    }

    /**
     * Test method for {@link LinkedDeque#addFront(Object)}
     */
    @Test
    void testAddFront2() {
        myQueue.addFront(6);
        myQueue.addFront(-12);
        assertEquals("add failed: queue size expected 2 instead of " + myQueue.size(), 2, myQueue.size());
        assertEquals("to string failed: expected head -> -12, 6 instead of " + myQueue.toString(), myQueue.toString(),
                "head -> -12, 6");
    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)} {@link LinkedDeque#addFront(Object)}
     */
    @Test
    void testAddFrontRear1() {
        myQueue.addFront(6);
        myQueue.addRear(-12);
        myQueue.addRear(5025);
        assertEquals("add failed: queue size expected 3 instead of " + myQueue.size(), 3, myQueue.size());
        assertEquals("to string failed: expected head -> 6, -12, 5025 instead of " + myQueue.toString(),
                myQueue.toString(), "head -> 6, -12, 5025");
    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)} {@link LinkedDeque#addFront(Object)}
     */
    @Test
    void testAddFrontRear2() {
        myQueue.addRear(6);
        myQueue.addFront(-12);
        myQueue.addFront(5025);
        assertEquals("add failed: queue size expected 3 instead of " + myQueue.size(), 3, myQueue.size());
        assertEquals("to string failed: expected head -> 5025, -12, 6 instead of " + myQueue.toString(),
                myQueue.toString(), "head -> 5025, -12, 6");
    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)} {@link LinkedDeque#removeRear()}
     */
    @Test
    void testRemoveRear1() {
        myQueue.addRear(6);
        myQueue.removeRear();
        assertEquals("add failed: queue size expected 0 instead of " + myQueue.size(), 0, myQueue.size());
        assertEquals("to string failed: expected head -> instead of " + myQueue.toString(), myQueue.toString(),
                "head ->");
    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)} {@link LinkedDeque#removeRear()}
     */
    @Test
    void testRemoveRear2() {
        myQueue.addRear(6);
        myQueue.addRear(-12);
        myQueue.removeRear();
        myQueue.removeRear();
        assertEquals("add failed: queue size expected 0 instead of " + myQueue.size(), 0, myQueue.size());
        assertEquals("to string failed: expected head -> instead of " + myQueue.toString(), myQueue.toString(),
                "head ->");
    }

    /**
     * Test method for {@link LinkedDeque#addFront(Object)} {@link LinkedDeque#removeFront()}
     */
    @Test
    void testRemoveFront1() {
        myQueue.addFront(6);
        myQueue.removeFront();
        assertEquals("add failed: queue size expected 0 instead of " + myQueue.size(), 0, myQueue.size());
        assertEquals("to string failed: expected head -> instead of " + myQueue.toString(), myQueue.toString(),
                "head ->");
    }

    /**
     * Test method for {@link LinkedDeque#addFront(Object)} {@link LinkedDeque#removeFront()}
     */
    @Test
    void testRemoveFront2() {
        myQueue.addFront(6);
        myQueue.addFront(-12);
        myQueue.removeFront();
        myQueue.removeFront();
        assertEquals("add failed: queue size expected 0 instead of " + myQueue.size(), 0, myQueue.size());
        assertEquals("to string failed: expected head -> instead of " + myQueue.toString(), myQueue.toString(),
                "head ->");
    }

    /**
     * Test method for {@link LinkedDeque#addRear(Object)} {@link LinkedDeque#peekRear()}
     */
    @Test
    void testPeekRear() {
        myQueue.addRear(6);
        assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
        assertTrue("peek failed: expected 6", myQueue.peekRear() == 6);
    }

    /**
     * Test method for {@link LinkedDeque#addFront(Object)} {@link LinkedDeque#peekFront()}
     */
    @Test
    void testPeekFront() {
        myQueue.addFront(6);
        assertEquals("add failed: queue size expected 1 instead of " + myQueue.size(), 1, myQueue.size());
        assertTrue("peek failed: expected 6", myQueue.peekFront() == 6);
    }
}
