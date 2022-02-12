
/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
const xorOperation = function(n, start) {
  return Array.from(Array(n), (_, i) => start + i * 2).reduce((a, b) => a ^ b);
};
