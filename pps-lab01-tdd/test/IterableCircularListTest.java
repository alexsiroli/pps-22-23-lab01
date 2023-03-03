import lab01.step2.IterableCircularList;
import lab01.step2.IterableCircularListImpl;
import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class IterableCircularListTest {

    private static final int REPETITION_NUMBER = 100;
    private IterableCircularList circularList;

    @BeforeEach
    void beforeEach() {
        this.circularList = new IterableCircularListImpl();
    }

    @Test
    void checkNewList() {
        assertEquals(0, this.circularList.size());
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void addElement() {
        this.circularList.add(1);
        assertEquals(1, this.circularList.size());
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void CheckMultipleElements() {
        this.addMultipleElements();
        assertEquals(REPETITION_NUMBER, this.circularList.size());
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void checkForwardIterator() {
        this.addThreeElements();
        var iterator = this.circularList.forwardIterator();
        assertEquals(0,iterator.next());
        assertEquals(1,iterator.next());
        assertEquals(2,iterator.next());
        assertEquals(0,iterator.next());
    }

    @Test
    void checkBackwardIterator() {
        this.addThreeElements();
        var iterator = this.circularList.backwardIterator();
        assertEquals(2,iterator.next());
        assertEquals(1,iterator.next());
        assertEquals(0,iterator.next());
        assertEquals(2,iterator.next());
    }

    @Test
    void checkBackwardIteratorWithOneElement() {
        this.circularList.add(0);
        var iterator = this.circularList.backwardIterator();
        assertEquals(0,iterator.next());
        assertEquals(0,iterator.next());
        assertEquals(0,iterator.next());
        assertEquals(0,iterator.next());
    }

    private void addMultipleElements(){
        for (int i = 0; i < REPETITION_NUMBER; i++){
            this.circularList.add(i);
        }
    }

    private void addThreeElements() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
    }

}
