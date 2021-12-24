package blogandquestion.algorithms.linkedlist.frontmiddlebackqueue1670;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/01 20:40:51
 * description:
 */
public class FrontMiddleBackQueue {
//    private LinkedList<Integer> c;
//    public FrontMiddleBackQueue() {
//        c = new LinkedList<>();
//    }
//
//    public void pushFront(int val) {
//        if (c.cnt() == 0) {
//            c.add(val);
//        } else {
//            c.add(0, val);
//        }
//    }
//
//    public void pushMiddle(int val) {
//        if (c.cnt() == 0) {
//            c.add(val);
//        } else {
//            int idx = c.cnt() >> 1;
//            c.add(idx, val);
//        }
//    }
//
//    public void pushBack(int val) {
//        c.add(val);
//    }
//
//    public int popFront() {
//        if (c.cnt() == 0) {
//            return -1;
//        }
//        return c.removeFirst();
//    }
//
//    public int popMiddle() {
//        if (c.cnt() == 0) {
//            return -1;
//        }
//        int mid = c.cnt() >> 1;
//        if ((c.cnt() & 1) == 0) {
//            // c.size为偶数
//            return c.remove(mid - 1);
//        } else {
//            return c.remove(mid);
//        }
//    }
//
//    public int popBack() {
//        if (c.cnt() == 0) {
//            return -1;
//        }
//        return c.removeLast();
//    }


    // 改用ArrayList实现
    private final ArrayList<Integer> c;
    public FrontMiddleBackQueue() {
        c = new ArrayList<>();
    }

    public void pushFront(int val) {
        c.add(0, val);
    }

    public void pushMiddle(int val) {
        c.add(c.size() / 2, val);
    }

    public void pushBack(int val) {
        c.add(val);
    }

    public int popFront() {
        if (c.size() == 0) {
            return -1;
        }
        return c.remove(0);
    }

    public int popMiddle() {
        if (c.size() == 0) {
            return -1;
        }
        return c.remove((c.size() - 1) / 2);
    }

    public int popBack() {
        if (c.size() == 0) {
            return -1;
        }
        return c.remove(c.size() - 1);
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue f = new FrontMiddleBackQueue();
        f.pushFront(1);
        f.pushBack(2);
        f.pushMiddle(3);
        f.pushMiddle(4);
        int r0 = f.popFront();
        int r1 = f.popMiddle();
        int r2 = f.popMiddle();
        int r3 = f.popBack();
    }
}
