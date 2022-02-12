/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
const combinationSum = function(candidates, target) {
  let ret = [];
  dfs(0, [], 0);
  return ret;

  function dfs(sum, path, startIndex) {
    if (sum >= target) {
      if (sum === target) {
        ret.push(path.slice());
      }
      return;
    }
    for (let i = startIndex; i < candidates.length; i++) {
      path.push(candidates[i]);
      // candidates 中的数字可以无限制重复被选取，所以下次仍从i处开始遍历
      dfs(sum + candidates[i], path, i);
      path.pop();
    }
  }
};
