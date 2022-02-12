/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
const combinationSum3 = function (k, n) {
  const ret = [];
  dfs(0, n, [], 1);
  return ret;

  function dfs(sum, target, path, startIndex) {
    if (path.length === k) {
      if (sum === target) ret.push(path.slice());
      return;
    }
    for (let i = startIndex; i <= 9; i++) {
      path.push(i);
      dfs(sum + i, target, path, i + 1);
      path.pop();
    }
  }
};
