/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
const intersection = function(nums1, nums2) {
    let result = [];
    for (let e of nums1) {
        if (nums2.includes(e)) result.push(e);
    }
    // 题目要求输出数组中每个元素都是唯一的，利用set去重
    return [...new Set(result)];
};


const intersection1 = function (nums1, nums2) {
    let set = new Set(nums1);
    let ret = [];
    for (let e of nums2) {
        if (set.has(e)) {
            ret.push(e);
            set.delete(e);
        }
    }
    return ret;
}
