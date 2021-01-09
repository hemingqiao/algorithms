/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
const shiftGrid = function (grid, k) {
  let m = grid.length, n = grid[0].length;
  let ret = Array(m).fill(0).map(_ => []);
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      let temp = i * n + j + k;
      let r = (temp / n | 0) % m;
      let c = temp % n;
      ret[r][c] = grid[i][j];
    }
  }
  return ret;
};