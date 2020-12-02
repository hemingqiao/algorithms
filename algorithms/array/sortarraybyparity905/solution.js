
/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
  let len = A.length;
  let left = 0, right = len - 1;
  while (left < right) {
    // 从左边开始找到第一个不是偶数的索引
    while (left < right && (A[left] & 1) === 0) {
      left++;
    }
    // 从右边开始找到第一个不是奇数的索引
    while (left < right && (A[right] & 1) === 1) {
      right--;
    }
    let temp = A[left];
    A[left] = A[right];
    A[right] = temp;
  }
  return A;
};

let A = [3,1,2,4];
console.log(sortArrayByParity(A));
