
/**
 * @param {number[]} nums
 * @return {string}
 */
const largestNumber = function(nums) {
  let strs = nums.map(num => num + "");
  strs.sort((a, b) => a + b <= b + a ? 1 : -1);
  let res = strs.join("");
  if (res.startsWith("0")) return "0";
  return res;
};
