/*! *****************************************************************************
@author Heming
founded at 2020-11-20 13:13:31
created by IntelliJ IDEA
description: 11，盛最多水的容器
from: https://leetcode-cn.com/problems/container-with-most-water/
***************************************************************************** */

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    // 暴力解法
    let begin;
    let maxArea = 0;
    for (let i = 0; i < height.length; i++) {
        begin = height[i];
        for (let j = i + 1; j < height.length; j++) {
            let temp = Math.min(begin, height[j]) * (j - i);
            maxArea = Math.max(maxArea, temp);
        }
    }
    return maxArea;
};

let test = [1, 8, 6, 2, 5, 4, 8, 3, 7];
console.log(maxArea(test));

/**
 *
 * @param {number[]} height
 * @return {number}
 */
const maxAreaOpt = function (height) {
    let res = 0;
    let i = 0, j = height.length - 1;
    while (i < j) {
        // 每次比较结束之后移动较低的板，因为一旦移动，j - i肯定减小
        // 移动高的板会导致min(height[i], height[j])变小或者不变，此时围起来的面积一定减小
        // 而移动低的板时，min(height[i], height[j])可能不变，可能变小，但也可能变大，此时围起来的面积有增大的可能
        res = height[i] < height[j]
            ? Math.max(res, (j - i) * height[i++])
            : Math.max(res, (j - i) * height[j--]);
    }
    return res;
}

console.log(maxAreaOpt(test));
