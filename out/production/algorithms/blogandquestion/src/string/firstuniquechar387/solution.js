/*! *****************************************************************************
@author Heming
founded at 2020-11-26 18:50:45
created by IntelliJ IDEA
description: LeetCode 387：字符串中的第一个唯一字符
from：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
***************************************************************************** */

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  let arr = Array(128).fill(0);
  for (let c of s) {
    arr[c.charCodeAt(0)]++;
  }
  for (let i = 0; i < s.length; i++) {
    if (arr[s.charAt(i).charCodeAt(0)] === 1) return i;
  }
  return -1;
};
