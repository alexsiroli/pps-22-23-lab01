package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Optional<Integer>> list;
    private int pointer;

    public CircularListImpl() {
        this.list = new ArrayList<>();
        this.pointer = -1;
    }

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
        this.pointer = (this.pointer+1) % this.size();
        return this.pickElement();
    }

    @Override
    public Optional<Integer> previous() {
        this.pointer = this.pointer <= 0 ? this.size()-1 : this.pointer-1;
        return this.pickElement();
    }

    @Override
    public void reset() {
        this.pointer = -1;
    }

    private Optional<Integer> pickElement() {
        if (this.pointer < this.size()) {
            return this.list.get(this.pointer);
        }
        return Optional.empty();
    }
}
