/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
const findRotation = function(mat, target) {
  let m = mat.length, n = mat[0].length;
  if (m != n) return false;
  if (isEqual(mat, target)) return true;
  for (let k = 0; k < 3; k++) {
    let temp = rotate(mat);
    if (isEqual(temp, target)) return true;
    mat = temp;
  }
  return false;
};

// 将一个数组顺时针旋转90°，并返回旋转后的新数组
const rotate = arr => {
  let ret = Array.from(Array(arr[0].length), _ => []);
  arr.forEach(row => row.forEach((val, c) => ret[c].unshift(val)));
  return ret;
};

const isEqual = function (a, b) {
  let m = a.length, n = a[0].length;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (a[i][j] != b[i][j]) return false;
    }
  }
  return true;
};



const rotatePrev = function (arr) {
  let m = arr.length, n = arr[0].length;
  let ret = Array(n).fill(0).map(_ => []);
  for (let i = m - 1; i >= 0; i--) {
    for (let j = 0; j < n; j++) {
      ret[j].push(arr[i][j]);
    }
  }
  return ret;
};


let mat = [[0,0,0],[0,0,1],[0,0,1]], target = [[0,0,0],[0,0,1],[0,0,1]];
console.log(findRotation(mat, target));

const rotateMod = arr => {
  let ret = Array.from(Array(arr[0].length), _ => []);
  arr.forEach((row) => {
    row.forEach((val, c) => {
      ret[c].unshift(val);
    });
  });
  return ret;
};

console.log(rotateMod(mat));
