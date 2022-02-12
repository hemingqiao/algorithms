/**
 * @param {number[]} nums
 * @return {number[]}
 */
const frequencySort = function (nums) {
  const map = new Map();
  for (let e of nums) {
    if (map.get(e) !== undefined) {
      map.set(e, map.get(e) + 1);
    } else {
      map.set(e, 1);
    }
  }
  nums.sort((a, b) => {
    let fre1 = map.get(a);
    let fre2 = map.get(b);
    if (fre1 === fre2) {
      return b - a;
    }
    return fre1 - fre2;
  });
  return nums;
};
