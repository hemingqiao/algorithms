/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const maxFrequency = function (nums, k) {
    let n = nums.length;
    nums.sort((a, b) => a - b);
    let s = [0];
    for (let i = 1; i <= n; i++) s.push(s[i - 1] + nums[i - 1]);
    let res = 0;
    for (let i = 1; i <= n; i++) {
        let l = 1, r = i;
        while (l < r) {
            let mid = l + r >> 1;
            if (nums[i - 1] * (i - mid + 1) - (s[i] - s[mid - 1]) <= k) r = mid;
            else l = mid + 1;
        }
        res = Math.max(res, i - l + 1);
    }
    return res;
};
