/*
在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
就越大，就越能保留更多的区间。因此，采取的贪心策略为，优先保留结尾小且不相交的区
间。
具体实现是，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
择的区间不重叠的区间。
 */
const eraseOverlapIntervals = function (intervals) {
    if (intervals == null || intervals.length === 0) return 0;
    let n = intervals.length;
    intervals.sort((a, b) => a[1] - b[1]);
    // total为要移除的数组个数
    let total = 0, prev = intervals[0][1];
    for (let i = 1; i < n; i++) {
        if (intervals[i][0] < prev) {
            ++total;
        } else {
            prev = intervals[i][1];
        }
    }
    return total;
}
