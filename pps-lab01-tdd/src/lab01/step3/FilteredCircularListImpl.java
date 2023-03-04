package lab01.step3;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;

public class FilteredCircularListImpl implements FilteredCircularList {

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
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        if (!this.isEmpty()) {
            for (int n = 0; n < this.size(); n++) {
                Optional<Integer> element = this.circularList.next();
                if (predicate.test(element.get()))
                    return element;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return this.circularList.previous();
    }

    @Override
    public void reset() {
        this.circularList.reset();
    }
}
