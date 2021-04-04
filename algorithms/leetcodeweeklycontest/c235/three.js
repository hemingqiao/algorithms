/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
const minAbsoluteSumDiff = function(nums1, nums2) {
  let n = nums1.length;
  let diff = [];
  for (let i = 0; i < n; i++) {
    diff.push(nums1[i] - nums2[i]);
  }
  let sum = 0;
  let max = Math.abs(diff[0]);
  let maxIndex = 0;
  for (let i = 0; i < n; i++) {
    sum += Math.abs(diff[i]);
    if (Math.abs(diff[i]) > max) {
      maxIndex = i;
      max = Math.abs(diff[i]);
    }
  }
  if (sum === 0) return 0;
  let origin = sum;
  let prefix = origin - Math.abs(nums1[maxIndex] - nums2[maxIndex]);
  for (let i = 0; i < n; i++) {
    if (i === maxIndex) continue;
    let suffixSum = Math.abs(nums1[i] - nums2[maxIndex]);
    sum = Math.min(sum, prefix + suffixSum);
  }
  return sum % (1e9 + 7);
};

minAbsoluteSumDiff([1,7,5], [2,3,5]);