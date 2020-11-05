/* 这题实际上就是求解斐波那契数列，使用尾递归求解 */

const climbStairs = function (n) {
    return fib(n, 1, 1);

    function fib(n, a, b) {
        if (n < 1) return a;
        return fib(n - 1, b, a + b);
    }
}

// test
for (let i = 0; i < 10; i++) {
    console.log(climbStairs(i));
}
