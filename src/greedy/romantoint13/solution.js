/*! *****************************************************************************
@author Heming
founded at 2020-11-23 22:32:11
created by IntelliJ IDEA
description: LeetCode 13 罗马数字转整数
from：https://leetcode-cn.com/problems/roman-to-integer/
***************************************************************************** */

/**
 * @param {string} s
 * @return {number}
 */
const romanToInt = function(s) {
  let pre = getValue(s.charAt(0));
  let res = 0;
  for (let i = 1; i < s.length; i++) {
    let num = getValue(s.charAt(i));
    if (pre < num) {
      res -= pre;
    } else {
      res += pre;
    }
    pre = num;
  }
  return res + pre;

  function getValue(c) {
    switch (c) {
      case 'I': return 1;
      case 'V': return 5;
      case 'X': return 10;
      case 'L': return 50;
      case 'C': return 100;
      case 'D': return 500;
      case 'M': return 1000;
      default: return 0;
    }
  }
};
