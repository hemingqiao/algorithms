/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var areAlmostEqual = function(s1, s2) {
  let n = s1.length;
  let cnt = 0;
  for (let i = 0; i < n; i++) {
    if (s1[i] != s2[i]) ++cnt;
  }
  if (cnt == 0) return true;
  let t1 = s1.split("").sort((a, b) => a > b ? 1 : a < b ? -1 : 0).join("");
  let t2 = s2.split("").sort((a, b) => a > b ? 1 : a < b ? -1 : 0).join("");
  return cnt == 2 && t1 == t2;
};

let s1 = "bank", s2 = "kanb";
console.log(areAlmostEqual(s1, s2));


var areAlmostEqual1 = function(s1, s2) {
    let n = s1.length;
    let cnt = 0;
    let count = [];
    for (let i = 0; i < n; i++) {
      if (s1[i] != s2[i]) {
        ++cnt;
        count.push(i);
      }
      if (cnt > 2) return false;
    }
    if (cnt == 0) return true;
    if (cnt == 1) return false;
    return s1[count[0]] == s2[count[1]] && s1[count[1]] == s2[count[0]];
};
