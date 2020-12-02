

/**
 * @param {number} n
 * @return {boolean}
 */
var canWinNim = function(n) {
  if (n < 3) return true;
  let dp = Array(4).fill(true);
  dp[0] = false;
  for (let i = 4; i <= n; i++) {
    dp[i % 4] = !dp[(i - 1) % 4] || !dp[(i - 2) % 4] || !dp[(i - 3) % 4];
  }
  return dp[n % 4];
};

console.log(canWinNim(4));

