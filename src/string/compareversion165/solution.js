/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
const compareVersion = function(version1, version2) {
  let splited1 = version1.split(".").map(item => +item),
      splited2 = version2.split(".").map(item => +item);

  let n1 = splited1.length, n2 = splited2.length;
  let max = Math.max(n1, n2);
  if (n1 < max) {
    splited1.push(...Array(max - n1).fill(0));
  }
  if (n2 < max) {
    splited2.push(...Array(max - n2).fill(0));
  }

  let ret = 0;
  for (let i = 0; i < max; i++) {
    if (splited1[i] == splited2[i]) {
      continue;
    } else {
      if (splited1[i] > splited2[i]) {
        ret = 1
      } else {
        ret = -1;
      }
      break;
    }
  }
  return ret;
};
