package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    final static int STARTING_INDEX = -1;

    private final List<Optional<Integer>> list = new ArrayList<>();
    private int pointer = STARTING_INDEX;

    @Override
    public void add(int element) {
        this.list.add(Optional.of(element));
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if (this.isEmpty()) {
            return Optional.empty();
        }
        this.pointer = (this.pointer+1) % this.size();
        return this.list.get(this.pointer);
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) {
            return Optional.empty();
        }
        this.pointer = this.pointer <= 0 ? this.size()-1 : this.pointer-1;
        return this.list.get(this.pointer);
    }

    @Override
    public void reset() {
        this.pointer = STARTING_INDEX;
    }
}
