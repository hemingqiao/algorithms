/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
const truncateSentence = function(s, k) {
  let strs = s.split(" ");
  let n = strs.length;
  if (n <= k) {
    return s;
  }
  return strs.slice(0, k).join(" ");
};
