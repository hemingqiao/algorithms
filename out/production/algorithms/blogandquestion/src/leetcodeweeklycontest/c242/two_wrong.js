/**
 * @param {number[]} dist
 * @param {number} hour
 * @return {number}
 */
const minSpeedOnTime = function(dist, hour) {
  // WA
  let min = Math.min(...dist);
  let m = hour / min;
  if (m < dist.length - 1) return -1;
  let maxSpeed = Math.ceil(m);
  let left = 0, right = maxSpeed;
  while (Math.ceil(left) < right) {
    let mid = (left + right) / 2;
    if (canReach(dist, hour, mid)) {
      right = mid;
    } else {
      left = mid;
    }
  }
  return Math.ceil(left);
};

function canReach(dist, hour, speed) {
  let n = dist.length;
  let sum = 0;
  for (let i = 0; i < n; i++) {
    let d = dist[i];
    sum += Math.ceil(d / speed);
  }
  return sum <= hour;
}

let dist = [1,1,100000];
let hours = 2.01;
console.log(minSpeedOnTime(dist, hours));