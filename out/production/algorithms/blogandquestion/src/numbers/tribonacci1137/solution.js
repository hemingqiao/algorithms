
/**
 * @param {number[]} nums
 * @return {number[]}
 */
const longestObstacleCourseAtEachPosition = function(nums) {
    let n = nums.length;
    let dp = Array(n).fill(1);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[j] <= nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    return dp;
};

console.log(longestObstacleCourseAtEachPosition([5, 1, 5, 5, 1, 3, 4, 5, 1, 4]));