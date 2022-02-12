/* 和AnotherSolution中的解法一致，只不过是将Java的写法转为了Javascript的写法 */

const removeCoveredIntervals = function (intervals) {
    if (intervals === null || intervals.length === 0) return 0;
    let res = [];
    intervals.sort((a, b) => {
        if (a[0] === b[0]) {
            return b[1] - b[0];
        }
        return a[0] - b[0];
    });
    let i = 0;
    while (i < intervals.length) {
        let left = intervals[i][0];
        let right = intervals[i][1];
        while (i < intervals.length - 1 && intervals[i + 1][0] >= left && intervals[i + 1][1] <= right) {
            i++;
        }
        res.push([left, right]);
        i++;
    }
    return res.length;
}
