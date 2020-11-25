package blogandquestion.algorithms.array.dayoftheweek1185;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 13:43:13
 * description:
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 *
 * 提示：
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 *
 */
public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] map = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 1971年1月1日是星期五
        //int start = 4;
        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        for (int j = 1; j < month; j++) {
            if (j == 2 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += months[j - 1];
            }
        }
        totalDays += day - 1;
        totalDays = totalDays % 7;
        return map[totalDays];
    }

    public boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 4 == 0 && year % 100 != 0) return true;
        return false;
        //return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static void main(String[] args) {
        String res = new Solution().dayOfTheWeek(1, 1, 1970);
        System.out.println(res);
    }
}
