
/**
 * @param {number[]} nums
 * @return {number}
 */
const arraySign = function(nums) {
  let res = nums.reduce((a, b) => a * b);
  return res > 0 ? 1 : res < 0 ? -1 : 0;
};

/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
const findTheWinner = function(n, k) {
  let nums = [];
  for (let i = 0; i < n; i++) {
    nums.push(1);
  }
  let p = 0;

  let j = 0;
  let move = 0;
  while (move < n - 1) {
    p %= n;
    while (p < n) {
      j %= n;
      if (nums[p] == 1) {
        j++;
      }
      if (j == k) {
        nums[p] = 0;
        // console.log(p + 1);
        ++move;
        if (move >= n - 1) break;
        j = 0;
      }
      p++;
    }
  }
  // console.log(nums);
  for (let i = 0; i < n; i++) {
    if (nums[i] == 1) {
      return i + 1;
    }
  }
};

// console.log(findTheWinner(3, 1));


const findTheWinner2 = function (n, k) {
  let nums = [];
  for (let i = 0; i < n; i++) nums[i] = i + 1;
  let p = 0;
  while (nums.length > 1) {
    p = (p + k - 1) % nums.length;
    nums.splice(p, 1);
  }
  return nums[0];
}

console.log(findTheWinner2(3, 1));
