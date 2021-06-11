/**
 * 先将数组排序，在利用双指针，也可以将算法的时间复杂度降到nlog(n)
 *
 * @param {any[]} nums
 * @param {number} target
 * @return {[number, number]}
 */
const twoSum = function(nums, target) {
  nums = nums.map((val, idx) => ({val, idx})).sort((a, b) => a.val - b.val);
  let n = nums.length;
  for (let i = 0, j = n - 1; i < n; i++) {
    let v = nums[i].val;
    while (j >= i && v + nums[j].val > target) j--;
    if (v + nums[j].val == target) return [nums[i].idx, nums[j].idx];
  }
  return [-1, -1];
};
