package blogandquestion.algorithms.doublepointer.minwindow76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 22:49:52
 * description:
 */
public class A {
    public void test() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 127);
        map.put('b', 127);
        map.put('c', 128);
        map.put('d', 128);
        System.out.println(map.get('a') == map.get('b')); // true
        System.out.println(map.get('c') == map.get('d')); // false
    }

    public static void main(String[] args) {
        new A().test();
    }
}
