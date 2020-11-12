package blogandquestion.algorithms.stack.removeduplicates1047;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 08:59:25
 * description:
 * 解题思路
 * see: https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin-zh/
 */
public class AnotherSolution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
                /*
                等同于：
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
                 */
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AnotherSolution s = new AnotherSolution();
        String test = "abbaca";
        String result = s.removeDuplicates(test);
        System.out.println(result);
    }
}
