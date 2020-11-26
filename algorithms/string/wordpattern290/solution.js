/*! *****************************************************************************
@author Heming
founded at 2020-11-26 16:17:27
created by IntelliJ IDEA
description:
***************************************************************************** */

/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function(pattern, s) {
  let sArr = s.split(" ");
  if (pattern.length !== sArr.length) return false;

  const map1 = new Map();
  const map2 = new Map();

  let len = sArr.length;
  for (let i = 0; i < len; i++) {
    // if (map1.get(pattern.charAt(i)) !== map2.get(sArr[i])) return false;
    // map1.set(pattern.charAt(i), i + 1);
    // map2.set(sArr[i], i + 1);
    if (map1.get(pattern.charAt(i)) === undefined) {
      map1.set(pattern.charAt(i), i + 1);
    }
    if (map2.get(sArr[i]) === undefined) {
      map2.set(sArr[i], i + 1);
    }
    if (map1.get(pattern.charAt(i)) !== map2.get(sArr[i])) {
      return false;
    }
  }
  return true;
};
