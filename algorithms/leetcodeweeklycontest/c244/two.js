/**
 * @param {number[]} nums
 * @return {number}
 */
const reductionOperations = function(nums) {
  nums.sort((a, b) => a - b);
  let level = new Set(nums).size;
  let res = 0;
  for (let j = nums.length - 1; j >= 0; j--) {
    let cnt = 1, i = j - 1;
    while (i >= 0 && nums[i] == nums[i + 1]) {
      ++cnt;
      i--;
      j--;
    }
    res += (level - 1) * cnt;
    level--;
  }
  return res;
};

console.log(reductionOperations([1,1,1]));
