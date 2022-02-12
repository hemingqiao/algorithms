/**
 * @param {number} x
 * @return {number}
 */
const reverse = function (x) {
    let result = 0;
    while (x !== 0) {
        let y = x % 10;
        if (x < 0) {
            x = Math.ceil(x / 10);
        } else {
            x = Math.floor(x / 10);
        }
        result = result * 10 + y;
    }
    // result | 0 超过32位的整数转换结果不等于自身，可用作溢出判断
    return (result | 0) === result ? result : 0;
};


/**
 * 参考：https://leetcode-cn.com/problems/reverse-integer/solution/wei-yun-suan-ji-jian-jie-fa-by-ijzqardmbd/
 * @param {number} x
 * @return {number}
 */
const reverseMath = function (x) {
    let result = 0;
    while (x !== 0) {
        let y = x % 10;
        // 通过 | 0 取整，无论正负，只移除小数点部分（正数向下取整，负数向上取整）。
        x = x / 10 | 0;
        result = result * 10 + y;
    }
    // result | 0 超过32位的整数转换结果不等于自身，可用作溢出判断
    return (result | 0) === result ? result : 0;
}
