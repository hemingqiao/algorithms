package blogandquestion.algorithms.binarysearch.firstbadversion278;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/13 16:18:18
 * description:
 */
public class ExerciseSolution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
