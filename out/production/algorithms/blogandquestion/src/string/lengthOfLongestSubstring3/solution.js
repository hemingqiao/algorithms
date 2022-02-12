/*! *****************************************************************************
@author Heming
founded at 2020-11-28 09:46:09
created by IntelliJ IDEA
description: LeetCode 3：无重复字符的最长字串
from：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
***************************************************************************** */

/**
 * @param {string} s
 * @return {number}
 */
const lengthOfLongestSubstring = function (s) {
  const map = new Map();
  let left = 0;
  let maxLen = 0;
  for (let i = 0; i < s.length; i++) {
    if (map.has(s[i])) {
      // 当s[i]存在于map中时，表示是一个重复字符，查找出前一个s[i]出现的位置
      // 看是否对窗口内的字符有影响
      left = Math.max(left, map.get(s[i]));
    }
    map.set(s[i], i + 1);
    maxLen = Math.max(maxLen, i - left + 1); // 更新最大长度
  }
  return maxLen;
};
