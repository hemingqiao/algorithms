/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const permuteUnique = function (nums) {
  const ret = [];
  const used = Array(nums.length).fill(false);
  nums.sort((a, b) => a - b);
  dfs(nums, [], nums.length, used);
  return ret;

  function dfs(origin, path, size, used) {
    if (path.length === size) {
      ret.push(path.slice());
      return;
    }
    for (let i = 0; i < origin.length; i++) {
      // 不能在同一层中使用重复的元素，而在不同层使用重复元素时，nums[i] == nums[i - 1]，但是此时used[i - 1] == true
      // 而如果在同一层使用了重复元素时，used[i - 1]此时为false
      // 或者当used[i]为true时，直接跳过
      if (i > 0 && origin[i] === origin[i - 1] && !used[i - 1] || used[i]) continue;
      path.push(origin[i]);
      used[i] = true;
      dfs(origin, path, size, used);
      used[i] = false;
      path.pop();
    }
  }
};
