/**
 * @param {number} n
 * @return {boolean}
 */
const isHappy = function(n) {
    const set = new Set();
    while (true) {
        let sum = getSum(n);
        if (sum === 1) return true;

        if (set.has(sum)) {
            return false;
        } else {
            set.add(sum);
        }
        n = sum;
    }

    function getSum(n) {
        let sum = 0;
        while (n) {
            sum += (n % 10) ** 2;
            n = Math.floor(n / 10);
        }
        return sum;
    }
};
