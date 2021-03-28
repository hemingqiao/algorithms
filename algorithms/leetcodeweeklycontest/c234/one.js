/**
 * @param {string} word
 * @return {number}
 */
var numDifferentIntegers = function(word) {
  let ret = word.match(/\d+/g);
  return ret == null ? 0 : new Set(ret.map(str => BigInt(str))).size;
};
