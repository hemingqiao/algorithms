/** 求解斐波那契数列 **/

/**
 * @param {number} N
 * @return {number}
 */
const fib = function (N) {
    return fibAuxiliary(N, 0, 1);

    function fibAuxiliary(N, a, b) {
        if (N === 0) return a;
        return fibAuxiliary(N - 1, b, a + b);
    }
};

for (let i = 0; i < 10; i++) {
    console.log(fib(i));
}

// memorize version

/**
 * @param {number} n
 * @return {number}
 */
const fib1 = function(n, cache = []) {
    if (cache[n]) return cache[n];
    if (n == 0) return 0;
    if (n == 1) return 1;
    return cache[n] = fib1(n - 1, cache) + fib1(n - 2, cache);
};
