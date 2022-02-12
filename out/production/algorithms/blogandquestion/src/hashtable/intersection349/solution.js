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

const intersection2 = function (nums1, nums2) {
    nums1.sort((a, b) => a - b);
    nums2.sort((a, b) => a - b);
    let ret = [];
    let i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
    let idx = 0;
    while (i < n1 && j < n2) {
        if (nums1[i] < nums1[j]) {
            i++;
        } else if (nums1[i] > nums1[j]) {
            j++;
        } else {
            if (idx == 0 || nums1[i] != ret[idx - 1]) {
                ret[idx++] = nums1[i];
            }
            i++;
            j++;
        }
    }
    return ret;
}
