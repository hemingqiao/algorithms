/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let res = nums[0];
    let sum = nums[0];
    for (let i = 1; i < nums.length; i++) {
        // 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
        // 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
        if (sum > 0) {
            sum += nums[i];
        } else {
            sum = nums[i];
        }
        res = Math.max(res, sum);
    }
    return res;
};

console.log(maxSubArray([1, 2]));


/*! *****************************************************************************
@author HeMing
founded at 2020-11-19 20:04:00
created by WebStorm
description: 下面为动态规划解法
***************************************************************************** */

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArrayDP = function(nums) {
    let dp = Array(nums.length);
    dp[0] = nums[0];
    let maxSum = nums[0];

    for (let i = 1; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        maxSum = Math.max(maxSum, dp[i]);
    }
    return maxSum;
};

console.log(maxSubArrayDP([1, 2]));
