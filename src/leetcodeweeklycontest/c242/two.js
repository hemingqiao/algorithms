/**
 * @param {number[]} dist
 * @param {number} hour
 * @return {number}
 */
const minSpeedOnTime = function(dist, hour) {
  let left = 1, right = 2e7;
  while (left < right) {
    let mid = (left + right) >>> 1;
    if (canReach(dist, hour, mid)) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }
  return left == 2e7 ? -1 : left;
};

function canReach(dist, hour, speed) {
  let sum = 0, n = dist.length;
  for (let i = 0; i < n - 1; i++) {
    sum += Math.ceil(dist[i] / speed);
  }
  return sum + dist[n - 1] / speed <= hour;
}