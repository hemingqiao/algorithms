/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    nums.sort((a, b) => a - b);
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== i) return i;
    }
    return nums.length;
};

let res = missingNumber([3,0,1]);
console.log(res);


/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber1 = function(nums) {
    let total = 0, len = nums.length;
    let sum = len * (len + 1) / 2;
    for (let i = 0; i < nums.length; i++) {
        total += nums[i];
    }
    return sum - total;
};

