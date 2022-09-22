package src.greedy.romantoint13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/14 19:36:26
 * description:
 */
public class ExerciseSolution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(){{
            put('I', 1); put('V', 5); put('X', 10); put('L', 50);
            put('C', 100); put('D', 500); put('M', 1000);
        }};
        int n = s.length();
        if (n == 1) return map.get(s.charAt(0));
        int ret = 0;
        int i = 0;
        while(i < n - 1) {
            int l = map.get(s.charAt(i)), r = map.get(s.charAt(i + 1));
            if (l < r) {
                ret += r - l;
                i += 2;
            } else {
                ret += l;
                i++;
            }
            if (i == n - 1) {
                ret += map.get(s.charAt(i));
                break;
            }
        }
        return ret;
    }

    // 不用哈希表而改用switch语句会快上一倍还多
    public int romanToInt1(String s) {
        int ret = 0;
        int n = s.length();
        if (n == 1) return getValue(s.charAt(0));
        int i = 0;
        while (i < n - 1) {
            int l = getValue(s.charAt(i)), r = getValue(s.charAt(i + 1));
            if (l < r) {
                ret += r - l;
                i += 2;
            } else {
                ret += l;
                i++;
            }
            if (i == n - 1) {
                ret += getValue(s.charAt(i));
                break;
            }
        }
        return ret;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int intToRoman2(String s) {
        int n = s.length();
        int preNum = getValue(s.charAt(0));
        int ret = 0;
        for (int i = 1; i < n; i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) ret -= preNum;
            else ret += preNum;
            preNum = num;
        }
        return ret + preNum;
    }
}
