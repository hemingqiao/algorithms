/**
 * @param {string} n
 * @param {number} x
 * @return {string}
 */
const maxValue = function(n, x) {
  let nums = n.split(""), len = nums.length;
  if (n.startsWith("-")) {
    for (let i = 1; i < len; i++) {
      // 负数从左到右找到第一个大于x的位置，插入，如果找不到，直接拼接到末尾
      // -421 3 => -3421
      // -121 3 => -1213
      if (+nums[i] > x) {
        return "-" + nums.slice(1, i).join("") + x + nums.slice(i).join("");
      }
    }
    return n + x;
  } else {
    for (let i = 0; i < len; i++) {
      // 整数从左到右找到第一个小于x的位置插入，如果找不到，直接拼接到末尾
      // 442 3 => 4432
      if (+nums[i] < x) {
        return nums.slice(0, i).join("") + x + nums.slice(i).join("");
      }
    }
    return n + x;
  }
};

console.log(maxValue("-132", 3));
