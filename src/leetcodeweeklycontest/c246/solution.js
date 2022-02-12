/**
 * @param {string} num
 * @return {string}
 *
 * TLE
 */
const largestOddNumber = function (num) {
    let n = num.length;
    if (BigInt(num) % BigInt(2) === 1n) return num;
    if (num.split("").every(i => i % 2 == 0)) return "";
    let res = BigInt(0);
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            let t = BigInt(num.substring(i, j));
            if (t % BigInt(2) === 1n) {
                if (t > res) res = t;
            }
        }
    }
    return res.toString();
};


/**
 * @param {string} num
 * @return {string}
 */
const largestOddNumber1 = function (num) {
    let n = num.length;
    if (Number(num[n - 1]) % 2 === 1) return num;
    for (let i = n - 2; i >= 0; i--) {
        if (Number(num[i]) % 2 !== 0) {
            return num.substring(0, i + 1);
        }
    }
    return "";
};

console.log(largestOddNumber1("152"));


/**
 * @return {number}
 * @param {string} a
 * @param {string} b
 */
const numberOfRounds = function (a, b) {
    let h1 = +a.substring(0, 2), h2 = +b.substring(0, 2);
    let m1 = +a.substring(3, a.length), m2 = +b.substring(3, b.length);
    let total = 0;
    if (h1 * 60 + m1 > h2 * 60 + m2) total += 24 * 60;
    if (m1 % 15 !== 0) m1 = ((m1 / 15 | 0) + 1) * 15;
    if (m2 % 15 !== 0) m2 = ((m2 / 15 | 0)) * 15;
    total += (h2 - h1) * 60 + m2 - m1;
    return Math.max(total / 15, 0); // 应对 "12:01", "12:02" 这类情况
};

console.log(numberOfRounds("00:01", "00:00"));
