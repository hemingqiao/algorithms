/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
const combine = function (n, k) {
  const ret = [];
  dfs(k, [], 1);
  return ret;

  function dfs(size, path, startIndex) {
    if (path.length === size) {
      ret.push(path.slice());
      return;
    }
    // 剪枝
    for (let i = startIndex; i <= n - (k - path.length) + 1; i++) {
      path.push(i);
      dfs(size, path, i + 1);
      path.pop();
    }
  }
};
