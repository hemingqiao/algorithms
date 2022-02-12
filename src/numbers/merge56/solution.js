/**
 * 合并区间
 * @param intervals type: [][]
 * @returns {[]|*[]} type: [][]
 */
const merge = function (intervals) {
    if (intervals === null || intervals.length === 0) return [];
    intervals.sort((a, b) => a[0] - b[0]);
    let i = 0;
    let res = [];
    while (i < intervals.length) {
        let left = intervals[i][0];
        let right = intervals[i][1];
        while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
            // 如果区间有重叠，对i自增，并更新right值，继续循环比较下一个区间
            i++;
            right = Math.max(right, intervals[i][1]);
        }
        // 否则直接将区间添加进结果列表，继续循环比较下一个区间
        res.push([left, right]);
        i++;
    }
    return res;
}
