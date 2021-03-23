package blogandquestion.algorithms.stack.nestediterator341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/23 22:01:45
 * description:
 * 二刷
 */
public class ExerciseSolution {
    static class NestedIterator implements Iterator<Integer> {
        private List<Integer> container = new ArrayList<>();
        private int p = 0;
        private int size;

        public NestedIterator(List<NestedInteger> nestedList) {
            traversal(nestedList);
            this.size = container.size();
        }

        @Override
        public Integer next() {
            return container.get(p++);
        }

        @Override
        public boolean hasNext() {
            return p < size;
        }

        private void traversal(List<NestedInteger> list) {
            for (NestedInteger n : list) {
                if (n.isInteger()) {
                    container.add(n.getInteger());
                } else {
                    traversal(n.getList());
                }
            }
        }
    }

    static class NestedIterator1 implements Iterator<Integer> {
        private List<Integer> container = new ArrayList<>();
        private Iterator<Integer> iterator;

        public NestedIterator1(List<NestedInteger> nestedList) {
            traversal(nestedList);
            this.iterator = container.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void traversal(List<NestedInteger> list) {
            for (NestedInteger n : list) {
                if (n.isInteger()) {
                    container.add(n.getInteger());
                } else {
                    traversal(n.getList());
                }
            }
        }
    }
}
