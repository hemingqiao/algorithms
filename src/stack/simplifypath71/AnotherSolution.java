package src.stack.simplifypath71;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 16:08:50
 * description:
 */
public class AnotherSolution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        String[] stack = new String[strings.length];
        int hh = 0;
        for (String i : strings) {
            if (i == null || i.length() == 0) {
                continue;
            }
            if ("..".equals(i)) {
                if (hh <= 0) {
                    continue;
                } else {
                    hh--;
                }
                continue;
            }
            if (".".equals(i)) {
                continue;
            }
            stack[++hh] = i;
        }
        if (hh <= 0) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= hh; i++) {
            sb.append("/");
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
