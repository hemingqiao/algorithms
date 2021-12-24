package blogandquestion.algorithms;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/16 08:38:20
 * description:
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            int n2 = num2.charAt(i) - '0';
            for (int i1 = 0; i1 < num2.length() - 1 - i; i1++) {
                temp.append(0);
            }

            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                temp.append((n1 * n2 + carry) % 10);
                carry = (n1 * n2 + carry) / 10;
            }

            res = addStrings(res, temp.reverse().toString());
        }

        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--,j--) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();
        String t1 = "123";
        String t2 = "0001";
        String result = m.addStrings(t1, t2);
        System.out.println(result);
    }
}
