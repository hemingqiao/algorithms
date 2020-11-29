/*! *****************************************************************************
@author Heming
founded at 2020-11-29 10:45:05
created by IntelliJ IDEA
description: LeetCode 125：验证回文串
from：https://leetcode-cn.com/problems/valid-palindrome/
***************************************************************************** */

/**
 * @param {string} s
 * @return {boolean}
 */
const isPalindrome = function (s) {
  if (s.length === 0) return true;
  s = s.toLowerCase();
  let low = 0, high = s.length - 1;
  while (low < high) {
    if (!validChar(s[low])) {
      low++;
      continue;
    }
    if (!validChar(s[high])) {
      high--;
      continue;
    }
    if (s[low] !== s[high]) return false;
    low++;
    high--;
  }
  return true;

  /**
   * 如果字符c是小写字母或者数字，返回true，否则，返回false
   * @param c
   * @return {boolean}
   */
  function validChar(c) {
    let code = c.charCodeAt(0);
    return !(code < 48 || code > 57 && code < 97 || code > 122);
  }
};


/**
 * 没有上面执行的快😂
 * @param {string} s
 * @return {boolean}
 */
const isPalindromeReg = function (s) {
  if (s.length === 0) return true;
  s = s.toLowerCase();
  let low = 0, high = s.length - 1;
  let regexp = /[^0-9a-zA-Z]/;
  while (low < high) {
    // 使用正则表达式进行校验
    if (regexp.test(s[low])) {
      low++;
      continue;
    }
    if (regexp.test(s[high])) {
      high--;
      continue;
    }
    if (s[low] !== s[high]) {
      return false;
    }
    low++;
    high--;
  }
  return true;
}
