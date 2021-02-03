/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const medianSlidingWindow = function (nums, k) {
  // TLE（超时）
  let n = nums.length, i = 0;
  let res = [];
  let temp = [];
  let flag = k % 2 == 0;
  while (temp.length < k) temp.push(nums[i++]);
  let copy = temp.slice();
  copy.sort((a, b) => a - b);
  if (flag) res.push((copy[k / 2 - 1] + copy[k / 2]) / 2);
  else res.push(copy[k / 2 | 0]);
  for (; i < n; i++) {
    temp.shift();
    temp.push(nums[i]);
    copy = temp.slice();
    copy.sort((a, b) => a - b);
    if (flag) res.push((copy[k / 2 - 1] + copy[k / 2]) / 2);
    else res.push(copy[k / 2 | 0]);
  }
  return res;
};

let arr = [1,3,-1,-3,5,3,6,7];
console.log(medianSlidingWindow(arr, 3));
