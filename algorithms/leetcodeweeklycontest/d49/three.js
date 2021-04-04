/**
 * @param {number[]} nums
 * @return {number}
 */
const countNicePairs = function(nums) {
  // TLE
  let n = nums.length;
  let cnt = 0;
  const map = new Map();
  for (let i = 0; i < n - 1; i++) {
    let x;
    if (map.has(nums[i])) {
      x = map.get(nums[i]);
    } else {
      x = getRev(nums[i]);
      map.set(nums[i], x);
    }
    for (let j = i + 1; j < n; j++) {
      let y;
      if (map.has(nums[j])) {
        y = map.get(nums[j]);
      } else {
        y = getRev(nums[j]);
        map.set(nums[j], y);
      }
      if (nums[i] + y === x + nums[j]) cnt++;
    }
  }
  return cnt % (1e9 + 7);


  function getRev(num) {
    let res = 0;
    while (num != 0) {
      res = res * 10 + num % 10;
      num = (num / 10 | 0);
    }
    return res;
  }
};

const countNicePairs1 = function(nums) {
  let map = new Map();
  let n = nums.length;
  let ret = 0;
  for (let i = 0; i < n; i++) {
    let temp = nums[i] - getRev(nums[i]);
    let p = map.get(temp) | 0; // undefined | 0 == 0
    ret += p;
    map.set(temp, p + 1);
  }
  return ret % (1e9 + 7);

  function getRev(num) {
    let res = 0;
    while (num != 0) {
      res = res * 10 + num % 10;
      num = (num / 10 | 0);
    }
    return res;
  }
};

let arr = [42, 11, 1, 97];
console.log(countNicePairs(arr));
