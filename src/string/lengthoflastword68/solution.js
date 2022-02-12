
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
  let res = 0;
  let times = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    if (s.charAt(i) === ' ' && times === 0) {
      continue;
    }
    if (s.charAt(i) !== ' ') {
      times = 1;
      res++;
    } else {
      break;
    }
  }
  return res;
};
