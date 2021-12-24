package blogandquestion.algorithms.dp.maxsubarray53;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/16 18:03:59
 * description:
 */
public class MaximumSubArray {
    static int N = (int) 1e4;
    static int BOUNDARY = N;

    public int[] generateRandomArray(int size, int boundary) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            int sign = Math.random() < 0.2 ? -1 : 1;
            ret[i] = (int) (Math.random() * boundary) * sign;
        }
        return ret;
    }

    public int maximumSubarray(int[] nums) {
        int ans = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                for (int k = j; k <= i; k++) {
                    sum += nums[k];
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public int maximumSubarray1(int[] nums) {
        int ans = Integer.MIN_VALUE, n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                ans = Math.max(ans, s[i + 1] - s[j]);
            }
        }
        return ans;
    }

    public int maximumSubarray2(int[] nums) {
        return calc(0, nums.length - 1, nums);
    }

    public int calc(int l, int r, int[] nums) {
        if (l >= r) return nums[l];
        int mid = l + r >> 1;
        int lmax = nums[mid], lsum = 0, rmax = nums[mid + 1], rsum = 0;
        for (int i = mid; i >= l; i--) {
            lsum += nums[i];
            lmax = Math.max(lmax, lsum);
        }
        for (int i = mid + 1; i <= r; i++) {
            rsum += nums[i];
            rmax = Math.max(rmax, rsum);
        }
        return Math.max(lmax + rmax, Math.max(calc(l, mid, nums), calc(mid + 1, r, nums)));
    }

    public int maximumSubarray3(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0, last = 0; i < nums.length; i++) {
            last = nums[i] + Math.max(last, 0);
            ans = Math.max(ans, last);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubArray ms = new MaximumSubArray();

        int[] test = ms.generateRandomArray(N, BOUNDARY);
        int[] copy1 = test.clone();
        int[] copy2 = test.clone();
        int[] copy3 = test.clone();

        double t = System.currentTimeMillis();
        System.out.println(ms.maximumSubarray(test));
        System.out.println(System.currentTimeMillis() - t + "ms elapsed");

        t = System.currentTimeMillis();
        System.out.println(ms.maximumSubarray1(copy1));
        System.out.println(System.currentTimeMillis() - t + "ms elapsed");

        t = System.currentTimeMillis();
        System.out.println(ms.maximumSubarray2(copy2));
        System.out.println(System.currentTimeMillis() - t + "ms elapsed");

        t = System.currentTimeMillis();
        System.out.println(ms.maximumSubarray3(copy3));
        System.out.println(System.currentTimeMillis() - t + "ms elapsed");
    }
}
