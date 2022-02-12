/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
const combinationSum2 = function(candidates, target) {
  candidates.sort((a, b) => a - b); // 升序排序以方便去重
  const ret = [];
  dfs(0, target, [], 0);
  return ret;

  function dfs(sum, target, path, startIndex) {
    if (sum >= target) {
      if (sum === target) {
        ret.push(path.slice());
      }
      return;
    }
    for (let i = startIndex; i < candidates.length; i++) {
      if (i > startIndex && candidates[i] === candidates[i - 1]) continue; // 执行去重
      path.push(candidates[i]);
      dfs(sum + candidates[i], target, path, i + 1);
      path.pop();
    }
  }
};
