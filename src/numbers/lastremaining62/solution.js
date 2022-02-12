
/**
 * @param {number} n
 * @param {number} m
 * @return {number}
 */
const lastRemaining = function(n, m) {
  let nums = Array.from(Array(n), (_, k) => k);
  let p = 0;
  while (nums.length > 1) {
    p = (p + m - 1) % nums.length;
    nums.splice(p, 1);
  }
  return nums[0];
};

console.log(lastRemaining(10, 17));
