/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
const myPow = function(x, n) {
    if (n === 0) return 1;
    if (n < 0) return myPow(1/x, -n);
    if ((n & 1) === 1) return x * myPow(x, n - 1); // 如果n为奇数
    let temp = myPow(x, n >> 1);
    return temp * temp;
};

console.log(myPow(1, -2147483648));
