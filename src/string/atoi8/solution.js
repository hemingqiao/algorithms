/**
 * 字符串装数字，正则写法
 * @param {string} s
 * @return {number}
 */
const myAtoi = function (s) {
    const regex = /^ *([+-]?\d+)/;
    let max = 2147483647, min = -2147483648;
    const match = s.match(regex);
    if (match == null) return 0;
    const num = +match[1];
    if (num > max) return max;
    if (num < min) return min;
    return num;
}
