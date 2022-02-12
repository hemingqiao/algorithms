
function binarySearch(arr, target) {
  let left = 0, right = arr.length;
  while (left < right) {
    let mid = (left + right) >>> 1;
    let t = arr[mid];
    if (t == target) {
      return mid;
    } else if (t > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }
  return -1;
}

let arr = [1,2,2,3,3,3,4,6];
console.log(binarySearch(arr, 3));
console.log(lower_bound(arr, 5));
console.log(upper_bound(arr,5));

function lower_bound(arr, target) {
  let left = 0, right = arr.length;
  while (left < right) {
    let mid = (left + right) >>> 1;
    if (arr[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }
  return left;
}

function upper_bound(arr, target) {
  let left = 0, right = arr.length;
  while (left < right) {
    let mid = (left + right) >>> 1;
    if (arr[mid] > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }
  return left;
}


console.log(lower_bound([1, 2, 3, 5], 6));
