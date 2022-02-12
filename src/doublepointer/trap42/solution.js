/*! *****************************************************************************
@author Heming
founded at 2020-11-20 12:51:34
created by IntelliJ IDEA
description: 42，接雨水
from：https://leetcode-cn.com/problems/trapping-rain-water/
***************************************************************************** */

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (!height.length) return 0;
    let len = height.length;
    let l_max = Array(len).fill(0), r_max = Array(len).fill(0);

    l_max[0] = height[0];
    r_max[len - 1] = height[len - 1];
    for (let i = 1; i < len; i++) {
        l_max[i] = Math.max(l_max[i - 1], height[i]);
    }
    for (let i = len - 2; i >= 0; i--) {
        r_max[i] = Math.max(r_max[i + 1], height[i]);
    }
    let total = 0;
    for (let j = 0; j < len; j++) {
        // 此处不需要判断min小于height[j]，因为min比较的两个值是统计了包括j处的两侧最大值
        // l_max[j] 和 r_max[j] 的最小值就是height[j]
        total += Math.min(l_max[j], r_max[j]) - height[j];
    }
    console.log(l_max);
    console.log(r_max);
    return total;
};

let test = [4,2,0,3,2,5];
console.log(trap(test));
