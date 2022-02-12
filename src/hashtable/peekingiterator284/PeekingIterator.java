package src.hashtable.peekingiterator284;

import java.util.Iterator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 16:56:40
 * description:
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 *
 * 示例:
 *
 * 假设迭代器被初始化为列表 [1,2,3]。
 *
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peeking-iterator
 *
 * 参考：https://leetcode-cn.com/problems/peeking-iterator/solution/java-liang-chong-jie-fa-by-npe_tle-3/
 */
public class PeekingIterator implements Iterator<Integer> {
    // cur相当于一个缓存
    private Integer cur;
    private final Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
        cur = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cur != null) {
            return cur;
        }
        cur = it.next();
        return cur;
    }

    @Override
    public boolean hasNext() {
        // 当cur为null时，调用peek获取cur的值会调用next方法
        // 当遍历到最后一个元素时，调用了peek方法，next指针会移到边界外，导致此时hasNext方法返回false
        // 而此时调用hasNext应该返回true，所以加入对cur != null的判断
        return cur != null || it.hasNext();
    }

    @Override
    public Integer next() {
        if (cur != null) {
            int res = cur;
            cur = null;
            return res;
        }
        return it.next();
    }
}
