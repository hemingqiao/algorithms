/*! *****************************************************************************
@author Heming
founded at 2020-11-24 18:45:55
created by IntelliJ IDEA
description: LeetCode 925：长按键入
from：https://leetcode-cn.com/problems/long-pressed-name/
***************************************************************************** */

/**
 * @param {string} name
 * @param {string} typed
 * @return {boolean}
 */
var isLongPressedName1 = function(name, typed) {
  let i = 0, j = 0;
  while (j < typed.length) {
    if (i < name.length && name[i] === typed[j]) {
      i++;
      j++;
    } else if (j > 0 && typed[j] === typed[j - 1]) {
      j++;
    } else {
      return false;
    }
  }
  return i === name.length;
};
