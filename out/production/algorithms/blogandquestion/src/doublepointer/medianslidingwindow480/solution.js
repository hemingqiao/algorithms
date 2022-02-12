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



/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
const medianSlidingWindow1 = function (nums, k) {
  let n = nums.length;
  let res = [], temp = [];
  for (let i = 0; i < k; i++) temp[i] = nums[i];
  temp.sort((a, b) => a - b);
  // let p = 0;
  // res[p++] = getMidNumber(temp);
  res.push(getMidNumber(temp));
  for (let i = 0; i < n - k; i++) {
    let index = binarySearch(temp, nums[i]); // 找到待删除元素的索引
    temp[index] = nums[i + k]; // 将待删除的数替换为从右边进入窗口的新数
    if (index < temp.length - 1 && temp[index] > temp[index + 1]) {
      let j = index + 1, temporary = temp[index];
      for (; j < temp.length && temp[j] < temporary; j++) {
        temp[j - 1] = temp[j];
      }
      temp[j - 1] = temporary;
    }
    if (index > 0 && temp[index] < temp[index - 1]) {
      let j = index - 1, temporary = temp[index];
      for (; j >= 0 && temp[j] > temporary; j--) {
        temp[j + 1] = temp[j];
      }
      temp[j + 1] = temporary;
    }
    // res[p++] = getMidNumber(temp);
    res.push(getMidNumber(temp));
  }
  return res;


  function getMidNumber(arr) {
    let n = arr.length;
    if ((n & 1) == 1) {
      return arr[n >> 1];
    } else {
      return arr[(n >> 1) - 1] / 2 + arr[n >> 1] / 2;
    }
  }

  function binarySearch(arr, target) {
    let left = 0, right = arr.length - 1;
    while (left <= right) {
      let mid = (left + right) >>> 1;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}

let arr = [1,3,-1,-3,5,3,6,7];
console.log(medianSlidingWindow1(arr, 3));
