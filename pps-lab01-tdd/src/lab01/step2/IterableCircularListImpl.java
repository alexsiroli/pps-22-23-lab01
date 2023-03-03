package lab01.step2;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class IterableCircularListImpl implements IterableCircularList {

    private final CircularList circularList = new CircularListImpl();

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new AbstractIterator(){

            @Override
            public Integer next() {
                return circularList.next().get();
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new AbstractIterator(){

            @Override
            public Integer next() {

                return circularList.previous().get();
            }
        };
    }

    private abstract static class AbstractIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return true;
        }
    }

}
