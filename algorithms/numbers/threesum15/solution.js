/* 将对应的Java写法转为JavaScript的写法 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const threeSum = function (nums) {
    let result = [];
    if (nums === null || nums.length === 0) return result;
    nums.sort((a, b) => a - b);
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) return result;
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        let left = i + 1, right = nums.length - 1;
        while (left < right) {
            if (nums[i] + nums[left] + nums[right] > 0) {
                right--;
            } else if (nums[i] + nums[left] + nums[right] < 0) {
                left++;
            } else {
                let temp = [];
                temp.push(nums[i], nums[left], nums[right]);
                result.push(temp);
                while (left < right && nums[right] === nums[right - 1]) right--;
                while (left < right && nums[left] === nums[left + 1]) left++;

                left++;
                right--;
            }
        }
    }
    return result;
}
