/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
const gameOfLife = function (board) {
  let dir = [[-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]];
  let copy = board.map(val => val.slice());
  let m = board.length, n = board[0].length;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      let count = countNeighbors(copy, i, j, m, n);
      if (copy[i][j] == 0) {
        if (count == 3) {
          board[i][j] = 1;
        }
      } else {
        if (count < 2 || count > 3) {
          board[i][j] = 0;
        }
      }
    }
  }


  function countNeighbors(board, i, j, m, n) {
    let count = 0;
    for (let d of dir) {
      let x = i + d[0];
      let y = j + d[1];
      if (x < 0 || x >= m || y < 0 || y >= n) continue;
      count += board[x][y];
    }
    return count;
  }
};
