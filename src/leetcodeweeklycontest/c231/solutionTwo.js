/**
 * @param {number[]} nums
 * @param {number} limit
 * @param {number} goal
 * @return {number}
 */
var minElements = function(nums, limit, goal) {
  let n = nums.length;
  let sum = 0;
  let cnt = 0;
  for (let i = 0; i < n; i++) sum += nums[i];
  let delta = goal - sum;

  if (delta < 0) {
    for (let j = limit; j >= 1; j--) {
      while (delta + j <= 0) {
        delta += j;
        ++cnt;
      }
      if (delta == 0) return cnt;
    }
  } else {
    for (let j = limit; j >= 1; j--) {
      while (delta - j >= 0) {
        delta -= j;
        ++cnt;
      }
      if (delta == 0) return cnt;
    }
  }
  return -1;
};
