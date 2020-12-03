package blogandquestion.algorithms.stack.nestediterator341;

import collections.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/03 12:49:45
 * description:
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 *
 * 参考：https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/java-liang-chong-jie-fa-by-wwwhang/
 * 参考：https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/javazhan-jie-fa-by-ye-mao-teng/
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        traversal(nestedList);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    @Override
    public Integer next() {
        return stack2.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack2.isEmpty();
    }

    // 用来flat嵌套列表
    private void traversal(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                stack1.push(ni.getInteger());
            } else {
                traversal(ni.getList());
            }
        }
    }
}

// or
class NestedIterator1 implements Iterator<Integer> {
    private final Iterator<Integer> it;

    public NestedIterator1(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        for (NestedInteger n : nestedList) {
            traversal(n, res);
        }
        it = res.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    private void traversal(NestedInteger ni, List<Integer> res) {
        if (ni.isInteger()) {
            res.add(ni.getInteger());
            return;
        }

        for (NestedInteger n : ni.getList()) {
            traversal(n, res);
        }
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
