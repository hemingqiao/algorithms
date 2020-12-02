

/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParityII = function(A) {
  let len = A.length;
  for (let i = 0; i < len - 1; i ++) {
    let j = i;

    // 当i（索引）是偶数时，找到i后面第一个偶数（(A[j] & 1) !== 1时退出循环）
    while (j < len && (A[j] & 1) === ((i & 1) === 1 ? 0 : 1)) {
      j++;
    }
    let temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  return A;
};

let A = [4,2,5,7];
let res = sortArrayByParityII(A)
console.log(res);
