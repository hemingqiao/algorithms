/**
 * @param {number[]} nums
 * @return {number[]}
 */
const sortArray = function (nums) {
  quickSort1(nums);
  return nums;

  function quickSort(nums, low = 0, high = nums.length - 1) {
    if (low >= high) return;
    swap(nums, low, Math.random() * (high - low + 1) | 0 + low);
    let pivot = nums[low];

    let j = low;
    for (let i = low + 1; i <= high; i++) {
      if (nums[i] < pivot) {
        swap(nums, ++j, i);
      }
    }
    swap(nums, j, low);

    quickSort(nums, low, j - 1);
    quickSort(nums, j + 1, high);
  }

  function quickSort1(nums, low = 0, high = nums.length - 1) {
    if (low >= high) return;
    swap(nums, low, Math.random() * (high - low + 1) | 0 + low);
    let pivot = nums[low];
    let left = low, right = high;
    while (left < right) {
      while (left < right && nums[right] >= pivot) right--;
      while (left < right && nums[left] <= pivot) left++;
      swap(nums, left, right);
    }
    nums[low] = nums[left];
    nums[left] = pivot;

    quickSort1(nums, low, left - 1);
    quickSort1(nums, left + 1, high);
  }

  function swap(nums, i, j) {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
};
