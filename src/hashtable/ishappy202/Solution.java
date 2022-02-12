package src.hashtable.ishappy202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 22:16:07
 * description:
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *  
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 *
 * 参考
 * https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247484202&idx=1&sn=f07d1166d61887007c2aa8c076a07365&scene=21#wechat_redirect
 */
public class Solution {
    // 当遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法
    // 又因为题目说可能无限循环，也就是某一些值会重复出现，当出现重复值时，就可以直接返回false了
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1) return true;

            if (set.contains(sum)) { // 如果sum出现过，说明进入了循环，此时直接返回false
                return false;
            } else {
                // 否则，把sum添加进set中
                set.add(sum);
            }
            // 更新n的值
            n = sum;
        }
    }

    /**
     * 获取一个数各个位的平方之和
     * @param n
     * @return
     */
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}

class AnotherSolution {
    // 题目说明可能无限循环，表明之前出现过的数字可能会重复出现，可以借助于set来判断一个数是否重复出现，如果重复出现，直接返回false
    // 否则，继续循环下去
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            else set.add(sum);
            n = sum;
        }
    }

    public int getSum(int n) {
        int sum = 0;
        // 这里的判断条件是n != 0，负数也可以处理？
        // 这个解法与上面解法唯一的差异便在于此，导致慢了1ms（50%）
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        System.out.println(as.isHappy(-1));
    }
}

/**
 * 不适用哈希表来存储每次的值来判断是否进入循环，而使用快慢指针来判断是否进入循环。
 * 参考：https://leetcode-cn.com/problems/happy-number/solution/shi-yong-kuai-man-zhi-zhen-si-xiang-zhao-chu-xun-h/
 */
class ThirdSolution {
    // 使用快慢指针判断是否进入循环
    public boolean isHappy(int n) {
        int slow = n, fast = n; // 初始时slow和fast相同
        do {
            // 快指针每次走两步，慢指针每次走一步，两者再次相同时退出循环
            // 退出循环时需要判断是到达1而导致的循环还是没有找到结果而导致的循环
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while (slow != fast);
        // 判断是找到结果导致退出循环还是没有找到结果而退出的循环
        return slow == 1;
    }

    /**
     * 获取一个数各个位上的平方之和
     * @param n
     * @return
     */
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
