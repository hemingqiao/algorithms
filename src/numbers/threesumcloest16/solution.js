/* 将Java的写法转化为对应JavaScript的写法 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const threeSumClosest = function (nums, target) {
    nums.sort((a, b) => a - b);
    let delta = Number.MAX_VALUE;
    let sum = Number.MIN_VALUE;
    for (let i = 0; i < nums.length; i++) {
        let left = i + 1, right = nums.length - 1;
        while (left < right) {
            let temp = nums[i] + nums[left] + nums[right];
            if (Math.abs(temp - target) < delta) {
                sum = temp;
                delta = Math.abs(temp - target);
            }
            if (temp - target === 0) {
                return sum;
            } else if (temp - target > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
    return sum;
}
