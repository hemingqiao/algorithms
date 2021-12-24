
function solution() {
  let nums1 = readline().split(" ").map(Number);
  // let nums1 = [2,1,1];
  let n1 = nums1.shift();
  let nums2 = readline().split(" ").map(Number);
  // let nums2 = [3,1,2,3];
  let n2 = nums2.shift();
  let k = Number(readline());
  // let k = 3;
  let ret = 0;
  let container = [];
  for (let i = 0; i < n1; i++) {
    for (let j = 0; j < n2; j++) {
      container.push(nums1[i] + nums2[j]);
    }
  }
  container.sort((a, b) => a - b);

  for (let i = 0; i < k; i++) {
    ret += container[i];
  }
  console.log(ret);
}

solution();
