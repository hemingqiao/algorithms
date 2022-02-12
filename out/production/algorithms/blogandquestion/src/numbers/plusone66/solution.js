/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let str = digits.join("");
    return addStrings(str, "1").split("").map(value => +value);

    function addStrings(str1, str2) {
        let carry = 0;
        let res = "";
        for (let i = str1.length - 1, j = str2.length - 1; i >= 0 || j >= 0 || carry !== 0; i--, j--) {
            let n1 = i < 0 ? 0 : +str1.charAt(i);
            let n2 = j < 0 ? 0 : +str2.charAt(j);
            res = (n1 + n2 + carry) % 10 + res;
            carry = Math.floor((n1 + n2 + carry) / 10);
        }
        return res;
    }
};

console.log(plusOne([0, 0]));

/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne1 = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        digits[i]++;
        digits[i] = digits[i] % 10;
        if (digits[i] !== 0) return digits;
    }
    let res = Array(digits.length + 1).fill(0);
    res[0] = 1;
    return res;
};