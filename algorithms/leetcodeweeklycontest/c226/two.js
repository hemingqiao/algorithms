/**
 * @param {number[][]} adjacentPairs
 * @return {number[]}
 */
// var restoreArray = function(adjacentPairs) {
//   for (let pair of adjacentPairs) {
//     if (pair[0] > pair[1]) {
//       let temp = pair[1];
//       pair[1] = pair[0];
//       pair[0] = temp;
//     }
//   }
//   adjacentPairs.sort((a, b) => a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//   let ret = [];
//   for (let i = 0; i < adjacentPairs.length; i++) {
//     let pair = adjacentPairs[i];
//     let a = Math.min(pair[0], pair[1]), b = Math.max(pair[0], pair[1]);
//     if (i == 0) {
//       ret.push(a, b);
//     } else {
//       if (a == ret[ret.length - 1]) {
//         ret.push(b);
//       } else if (b == ret[ret.length - 1]) {
//         ret.push(a);
//       }
//     }
//   }
//   return ret;
// };
//
// let test = [[4,-10],[-1,3],[4,-3],[-3,3]];
// console.log(restoreArray(test));