import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int REPETITION_NUMBER = 100;
    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl();
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
    void checkAddMultipleElements() {
        this.addMultipleElements();
        assertEquals(REPETITION_NUMBER, this.circularList.size());
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void checkNext() {
        this.addThreeElements();
        assertEquals(Optional.of(0), this.circularList.next());
        assertEquals(Optional.of(1), this.circularList.next());
        assertEquals(Optional.of(2), this.circularList.next());
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void checkMultipleNext() {
        this.addThreeElements();
        for (int i = 0; i < REPETITION_NUMBER; i++) {
            assertEquals(Optional.of(i%3), this.circularList.next());
        }
    }

    @Test
    void checkEmptyList() {
        assertEquals(Optional.empty(),this.circularList.next());
        assertEquals(Optional.empty(),this.circularList.previous());
    }

    @Test
    void checkPrevious() {
        this.addThreeElements();
        assertEquals(Optional.of(0), this.circularList.next());
        assertEquals(Optional.of(1), this.circularList.next());
        assertEquals(Optional.of(0), this.circularList.previous());
        assertEquals(Optional.of(2), this.circularList.previous());
    }

    @Test
    void checkReset() {
        this.addThreeElements();
        assertEquals(Optional.of(0), this.circularList.next());
        assertEquals(Optional.of(1), this.circularList.next());
        this.circularList.reset();
        assertEquals(Optional.of(0), this.circularList.next());
        assertEquals(Optional.of(1), this.circularList.next());
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
