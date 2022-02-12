/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
const isScramble = function(s1, s2) {
  // TLE
  if (s1.length != s2.length) return false;
  if (s1 == s2) return true;
  const compare = (a, b) => a < b ? -1 : a > b ? 1 : 0;
  if (s1.split("").sort(compare).join("") != s2.split("").sort(compare).join("")) return false;
  let n = s1.length;
  for (let i = 1; i < n; i++) {
    let s11 = s1.substring(0, i);
    let s12 = s1.substring(i);
    let s21 = s2.substring(0, i);
    let s22 = s2.substring(i);
    if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
    s21 = s2.substring(n - i);
    s22 = s2.substring(0, n - i);
    if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
  }
  return false;
};
