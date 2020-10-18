package blogandquestion.algorithms.string.longestcommonprefix14;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 19:15:31
 * description: 暴力遍历？就这执行时间都击败了88，内存击败96
 */
public class AnotherSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String answer = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < answer.length() && j < strs[i].length()) {
                if (answer.charAt(j) == strs[i].charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            answer = answer.substring(0, j);
            if (answer.equals("")) return answer;
        }
        return answer;
    }
}
