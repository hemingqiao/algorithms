/** 牛顿迭代法求解非负数平方根 **/

/**
 * 返回非负数的平方根
 * @param n
 * @returns {number}
 */
function sqrt(n) {
  let x0 = n;
  while (Math.abs(x0 * x0 - n) > Number.EPSILON) {
    x0 = (x0 + n / x0) / 2;
  }
  return x0;
}

// test
console.log(sqrt(0)); // 0
console.log(sqrt(1)); // 1
console.log(sqrt(64)); // 8
console.log(sqrt(99980001)); // 9999

/*
理论基础：牛顿迭代法
参考：https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95
参考：https://baike.baidu.com/item/%E7%89%9B%E9%A1%BF%E8%BF%AD%E4%BB%A3%E6%B3%95
 */
