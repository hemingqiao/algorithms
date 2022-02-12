/*! *****************************************************************************
@author Heming
founded at 2020-11-23 11:57:25
created by IntelliJ IDEA
description: 用最少的箭引爆气球 452
from：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
***************************************************************************** */

/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
  if (points == null || points.length === 0) return 0;
  points.sort((a, b) => a[1] < b[1] ? -1 : (a[1] === b[1] ? 0 : 1));
  let count = 1;
  let end = points[0][1];
  for (let i = 1; i < points.length; i++) {
    if (points[i][0] <= end) {
      continue;
    }
    count++;
    end = points[i][1];
  }
  return count;
};

let test = [[10,16],[2,8],[1,6],[7,12]];
console.log(findMinArrowShots(test));
