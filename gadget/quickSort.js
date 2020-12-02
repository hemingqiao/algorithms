/*! *****************************************************************************
@author Heming
founded at 2020-12-02 19:09:40
created by WebStorm
description: 三种不同的快速排序算法实现。
版本 1：基本方法：把等于切分元素的所有元素分到了数组的同一侧，可能会造成递归树倾斜；
版本 2：双指针法：把等于切分元素的所有元素等概率地分到了数组的两侧，避免了递归树倾斜，递归树相对平衡；
版本 3：三指针法：把等于切分元素的所有元素挤到了数组的中间，在有很多元素和切分元素相等的情况下，递归区间大大减少。
***************************************************************************** */


/**
 * 快排基本方法
 * @param {number[]} arr
 * @param {number} low
 * @param {number} high
 */
function quickSortVer1(arr, low = 0, high = arr.length - 1) {
  if (low >= high) return; // 当序列长度小于等于1时，结束递归

  let pivotIndex = Math.floor(Math.random() * (high - low + 1)) + low; // 随机选取一个元素作为基准
  swap(arr, low, pivotIndex);
  let pivot = arr[low];

  let j = low;
  for (let i = low + 1; i <= high; i++) {
    if (arr[i] < pivot) {
      swap(arr, ++j, i);
    }
  }
  // 退出循环后，[low + 1, j]区间内的值都小于pivot，(j, high]区间内的值都大于pivot
  // 将基准元素与j处元素交换之后，[low, j - 1]区间内的值都小于pivot，(j, high]区间内的值都大于pivot
  swap(arr, low, j);

  quickSortVer1(arr, low, j - 1);
  quickSortVer1(arr, j + 1, high);
}


/**
 * 快排双指针法
 * @param {number[]} arr
 * @param {number} low
 * @param {number} high
 */
function quickSortVer2(arr, low = 0, high = arr.length - 1) {
  if (low >= high) return; // 当序列长度小于等于1时，结束递归

  let pivotIndex = Math.floor(Math.random() * (high - low + 1)) + low; // 随机选取一个元素作为基准
  swap(arr, low, pivotIndex);
  let pivot = arr[low];
  let left = low, right = high;
  while (left < right) {
    while (left < right && arr[right] >= pivot) {
      right--;
    }
    while (left < right && arr[left] <= pivot) {
      left++;
    }
    swap(arr, left, right);
  }
  arr[low] = arr[left];
  arr[left] = pivot;

  quickSortVer2(arr, low, left - 1);
  quickSortVer2(arr, left + 1, high);
}

/**
 * 快排三指针法
 * @param {number[]} arr
 * @param {number} low
 * @param {number} high
 */
function quickSortVer3(arr, low = 0, high = arr.length - 1) {
  if (low >= high) return; // 当序列长度小于等于1时，结束递归

  let pivotIndex = Math.floor(Math.random() * (high - low + 1)) + low; // 随机选取一个元素作为基准
  swap(arr, low, pivotIndex);
  let pivot = arr[low];

  let lt = low; // lt指针为小于基准元素的值放置位置的索引
  let gt = high + 1; // gt指针为大于基准元素的值放置位置的索引
  let i = low + 1; // i指针用来遍历序列
  while (i < gt) {
    if (arr[i] < pivot) {
      // 当某个元素的值小于基准元素时，lt指针自增，将这个元素交换到lt指针处
      lt++;
      swap(arr, lt, i);
      i++; // i指针向后移动
    } else if (arr[i] === pivot) {
      i++;
    } else {
      // 当某个元素的值大于基准时，gt指针减1，将这个值换到gt指针处
      // 注意此处i指针没有发生变化，因为互换之后，i处元素值仍可能大于pivot，这是因为i指针尚未遍历到后面
      // i指针可以保证小于i的索引处的元素值都是小于等于pivot的，但对于大于i的索引不能保证，所以一直到互换之后i处值小于pivot后
      // i指针才会重新自增
      gt--;
      swap(arr, i, gt);
    }
  }
  // 交换之后，有以下关系成立
  // all in [left + 1, lt] < pivot
  // all in [lt + 1, i) = pivot
  // all in [gt, right] > pivot
  swap(arr, low, lt);

  // 递归的排序左半边区间和右半边区间，[lt, gt)区间内的值都等于pivot
  quickSortVer3(arr, low, lt - 1);
  quickSortVer3(arr, gt, high);
}


/**
 * 交换给定数组中的两个元素
 * @param arr
 * @param i
 * @param j
 */
function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

/**
 * 生成一个具有给定长度和边界的随机数数组并返回
 * @param size
 * @param boundary
 * @return {[]}
 */
function generateRandomArray(size, boundary) {
  let arr = [];
  for (let i = 0; i < size; i++) {
    arr.push(Math.random() * boundary | 0);
  }
  return arr;
}


// for test
let a = generateRandomArray(1500000, 100);
console.log(a);
quickSortVer3(a);
console.log(a);
