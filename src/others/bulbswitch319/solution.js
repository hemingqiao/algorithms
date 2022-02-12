/**
 * @param {number} n
 * @return {number}
 */
var bulbSwitch = function(n) {
    const res = [];
    for (let i = 1; i <= n; i++) {
        res[i - 1] = bulbSwitch(i, n);
    }
    console.log(res);
    return res.filter(value => value%2).length;

    /**
     * num个人之后，编号为bulb的灯泡共被按了多少次
     * @param bulb 灯泡编号
     * @param num 总人数
     * @returns {number}
     */
    function bulbSwitch(bulb, num) {
        let count = 0;
        for (let i = 1; i <= num; i++) {
            if (bulb % i === 0) count++;
        }
        return count;
    }
};

console.log("old", bulbSwitch(9999));

/**
 * @param {number} n
 * @return {number}
 */
var bulbSwitchOpt = function(n) {
    let sqrt_n = Math.floor(Math.sqrt(n));
    return sqrt_n;
};

console.log(bulbSwitchOpt(9999));
