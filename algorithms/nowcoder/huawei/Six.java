package blogandquestion.algorithms.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 11:52:07
 * description:
 */
public class Six {
    // 分解质因数
    // 利用了数学方法
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long sqrt = (long) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "" : num + " ");
    }

    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
