
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
const checkInclusion = function(s1, s2) {
  let n1 = s1.length, n2 = s2.length;
  if (n1 > n2) return false;
  let cnt1 = Array(128).fill(0), cnt2 = Array(128).fill(0);
  for (let i = 0; i < n1; i++) {
    cnt1[s1.charAt(i).charCodeAt(0)]++;
    cnt2[s2.charAt(i).charCodeAt(0)]++;
  }
  if (cnt1.toString() == cnt2.toString()) return true;
  for (let j = n1; j < n2; j++) {
    cnt2[s2.charAt(j).charCodeAt(0)]++;
    cnt2[s2.charAt(j - n1).charCodeAt(0)]--;
    if (cnt1.toString() == cnt2.toString()) return true;
  }
  return false;
};
