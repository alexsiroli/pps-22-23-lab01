import lab01.step3.FilteredCircularList;
import lab01.step3.FilteredCircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilteredCircularListTest {

    private static final int REPETITION_NUMBER = 100;
    private FilteredCircularList circularList;

    @BeforeEach
    void beforeEach() {
        this.circularList = new FilteredCircularListImpl();
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
    void checkFilteredNext() {
        this.addThreeElements();
        assertEquals(Optional.of(2), this.circularList.filteredNext(i -> i>1));
        assertEquals(Optional.of(2), this.circularList.filteredNext(i -> i>1));
        assertEquals(Optional.of(1), this.circularList.filteredNext(i -> i>0));
        assertEquals(Optional.of(2), this.circularList.filteredNext(i -> i>=0));
    }

    @Test
    void checkMultipleNext() {
        this.addThreeElements();
        for (int i = 0; i < REPETITION_NUMBER; i++) {
            assertEquals(Optional.of(2), this.circularList.filteredNext(n -> n>1));
        }
    }

    @Test
    void checkEmptyList() {
        assertEquals(Optional.empty(),this.circularList.filteredNext(n -> n>0));
        assertEquals(Optional.empty(),this.circularList.previous());
    }

    @Test
    void checkPrevious() {
        this.addThreeElements();
        assertEquals(Optional.of(0), this.circularList.filteredNext(i -> i >= 0));
        assertEquals(Optional.of(1), this.circularList.filteredNext(i -> i >= 0));
        assertEquals(Optional.of(0), this.circularList.previous());
        assertEquals(Optional.of(2), this.circularList.previous());
    }

    @Test
    void checkReset() {
        this.addThreeElements();
        assertEquals(Optional.of(0), this.circularList.filteredNext(i -> i >= 0));
        assertEquals(Optional.of(1), this.circularList.filteredNext(i -> i >= 0));
        this.circularList.reset();
        assertEquals(Optional.of(0), this.circularList.filteredNext(i -> i >= 0));
        assertEquals(Optional.of(1), this.circularList.filteredNext(i -> i >= 0));
    }

    @Test
    void NoElementAccepted() {
        this.addThreeElements();
        assertEquals(Optional.empty(), this.circularList.filteredNext(i -> i > 10));
        assertEquals(Optional.empty(), this.circularList.filteredNext(i -> i > 10));
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
