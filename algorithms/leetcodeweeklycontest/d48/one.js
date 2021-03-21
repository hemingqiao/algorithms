/**
 * @param {string} s
 * @return {number}
 */
const secondHighest = function(s) {
  let nums = s.split("").filter(e => !Object.is(+e, NaN)).map(e => +e);
  // let nums = s.split("").filter(e => e >= "0" && e <= "9").map(e => +e); // 没有上面执行的快
  nums = [...new Set(nums)];
  nums.sort((a, b) => a - b);
  if (nums.length >= 2) return nums[nums.length - 2];
  return -1;
};

let string = "ck077";
let res = secondHighest(string);
console.log(res);
