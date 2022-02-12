/**
 * @param {number[]} nums
 * @return {boolean}
 */
var check = function(nums) {
  let n = nums.length;
  let flag = -1;
  for (let i = 0; i < n - 1; i++) {
    if (nums[i] > nums[i + 1]) {
      flag = i;
      break;
    }
  }
  if (flag == -1) return true;
  let copy = nums.slice(flag + 1).concat(nums.slice(0, flag + 1));
  for (let i = 0; i < n - 1; i++) {
    if (copy[i] > copy[i + 1]) return false;
  }
  return true;
};
