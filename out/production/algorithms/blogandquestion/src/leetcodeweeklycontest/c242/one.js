
const checkZeroOnes = function(s) {
  let a = 0, b = 0;
  let n = s.length;
  let aa = 0, bb = 0;
  for (let i = 0; i < n; i++) {
    if (i == 0) {
      if (s[i] == "1") {
        ++aa;
        a = Math.max(a, aa);
      } else {
        ++bb;
        b = Math.max(b, bb);
      }
      continue;
    }
    if (s[i] == s[i - 1]) {
      if (s[i] == "1") {
        ++aa;
        a = Math.max(a, aa);
      } else {
        ++bb;
        b = Math.max(b, bb);
      }
    } else {
      if (s[i - 1] == "1") {
        a = Math.max(a, aa);
        ++bb;
        aa = 0;
      } else {
        b = Math.max(b, bb);
        ++aa;
        bb = 0;
      }
    }
  }
  return a > b;
};


/*
非常妙的解法，但是执行速度没有上面的代码快
 */
/**
 * @param {string} s
 * @return {boolean}
 */
const checkZeroOnes = function(s) {
  let res0 = 0, res1 = 0;
  let cur0 = 0, cur1 = 0;
  let n = s.length;
  for (let i = 0; i < n; i++) {
    if (s[i] == "0") {
      ++cur0;
      cur1 = 0;
    } else {
      ++cur1;
      cur0 = 0;
    }
    res0 = Math.max(res0, cur0);
    res1 = Math.max(res1, cur1);
  }
  return res1 > res0;
};
