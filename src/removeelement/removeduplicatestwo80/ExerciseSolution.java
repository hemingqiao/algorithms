package src.removeelement.removeduplicatestwo80;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/06 21:42:00
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/80
 */
public class ExerciseSolution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int num : nums) {
            // 由于这里最多允许两次重复，那么当前的数字 num 只要跟上上个覆盖位置的数字 nusm[p-2] 比较，若 num 较大，
            // 则绝不会出现第三个重复数字（前提是数组是有序的），这样的话根本不需要管 nums[p-1] 是否重复，只要将重复个数控制在2个以内就可以了
            if (p < 2 || num > nums[p - 2]) {
                nums[p++] = num;
            }
        }
        return p;
    }
}
