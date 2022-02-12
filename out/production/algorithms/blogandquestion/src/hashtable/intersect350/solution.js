/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
const intersect = function(nums1, nums2) {
    let result = [];
    for (let j = 0; j < nums1.length; j++) {
        for (let i = 0; i < nums2.length; i++) {
            if (nums2[i] === nums1[j]) {
                result.push(nums1[j]);
                // 一旦找到相同的元素，将这两个元素都置为NaN
                nums2[i] = NaN;
                nums1[j] = NaN;
            }
        }
    }
    return result;
};

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
const intersect2 = function(nums1, nums2) {
    nums1.sort((a, b) => a - b);
    nums2.sort((a, b) => a - b);
    let res = [];
    for (let i = 0, j = 0; i <nums1.length && j < nums2.length; ) {
        if (nums1[i] === nums2[j]) {
            res.push(nums1[i++]);
            j++;
        } else if (nums1[i] > nums2[j]) {
            j++;
        } else {
            i++;
        }
    }
    return res;
};

/**
 * 参考：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/350-liang-ge-shu-zu-de-jiao-ji-ii-javascript-by-hy/
 *
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
const intersect3 = function(nums1, nums2) {
    const map = {};
    const res = [];
    for (let num1 of nums1) {
        if (map[num1]) {
            map[num1]++;
        } else {
            map[num1] = 1;
        }
    }
    for (let num2 of nums2) {
        const val = map[num2];
        if (val > 0) { // num2在map中出现（大于0）
            res.push(num2);
            map[num2]--; // 匹配掉一个，就在map中减去一个
        }
    }
    return res;
};
