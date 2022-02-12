/**
 * @param {number[]} nums
 * @return {number}
 */
const arrayPairSum = function(nums) {
  quickSort(nums);
  let ret = 0, n = nums.length;
  for (let i = 0; i < n; i += 2) {
    ret += nums[i];
  }
  return ret;
};

function quickSort(arr, low = 0, high = arr.length - 1) {
  if (low >= high) return;
  swap(arr, low, (Math.random() * (high - low + 1) | 0) + low);
  let pivot = arr[low];
  let j = low;
  for (let i = low + 1; i <= high; i++) {
    if (arr[i] < pivot) {
      swap(arr, ++j, i);
    }
  }
  swap(arr, low, j);
  quickSort(arr, low, j - 1);
  quickSort(arr, j + 1, high);
}

function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}
