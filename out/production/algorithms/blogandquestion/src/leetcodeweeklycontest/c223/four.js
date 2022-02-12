/**
 * @param {number[]} jobs
 * @param {number} k
 * @return {number}
 */
const minimumTimeRequired = function (jobs, k) {
  // 记录每个工人的工作时间
  var record = new Array(k).fill(0);
  var min = Infinity;

  function backtrack(index) {
    // 得到一种分配方式，更新最优解
    if (index >= jobs.length) {
      min = Math.min(min, Math.max(...record));
      return;
    }

    var cache = {};
    // 尝试将工作分配给不同的工人
    for (var i = 0; i < record.length; i++) {
      // 剪枝，相同工作时间不需要再次尝试
      var n = record[i];
      if (cache[n]) continue;
      cache[n] = 1;

      // 剪枝，工作时间超过了当前的最优解
      if (record[i] + jobs[index] > min) continue;

      // 改变状态
      record[i] += jobs[index];

      // 递归
      backtrack(index + 1);

      // 回溯，还原状态
      record[i] -= jobs[index];
    }
  }

  backtrack(0);
  return min;
};

let jobs = [3,2,3], k = 3;
console.log(minimumTimeRequired(jobs, k));
