package src.greedy.inttoroman12;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/09 20:06:34
 * description: 使用人造哈希表
 * see: https://leetcode-cn.com/problems/integer-to-roman/solution/tan-xin-ha-xi-biao-tu-jie-by-ml-zimingmeng/
 */
public class AnotherSolution {
    public String intToRoman(int num) {
        String[][] table = {
                // 1~9
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                // 10~90
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                // 100~900
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                // 1000~3000
                {"", "M", "MM", "MMM"}
        };

        StringBuilder s = new StringBuilder();
        int count = 0;
        while (num > 0) {
            int temp = num % 10;
            s.insert(0, table[count++][temp]);
            num /= 10;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AnotherSolution().intToRoman(58));
    }

    public String intToRomanOpt(int num) {
        String[][] table = {
                // 1~9
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                // 10~90
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                // 100~900
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                // 1000~3000
                {"", "M", "MM", "MMM"}
        };

        StringBuilder s = new StringBuilder();
        s.append(table[3][num / 1000]);
        s.append(table[2][num / 100 % 10]);
        s.append(table[1][num / 10 % 10]);
        s.append(table[0][num % 10]);
        return s.toString();
    }
}
