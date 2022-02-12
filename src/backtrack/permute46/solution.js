/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const permute = function (nums) {
  const ret = [];
  const used = Array(nums.length).fill(false);
  dfs(nums, used, [], nums.length);
  return ret;

  function dfs(origin, used, path, size) {
    if (path.length === size) {
      ret.push([...path]);
      return;
    }
    for (let i = 0; i < origin.length; i++) {
      if (used[i]) continue;
      path.push(origin[i]);
      used[i] = true;
      dfs(origin, used, path, size);
      used[i] = false;
      path.pop();
    }
  }
};
