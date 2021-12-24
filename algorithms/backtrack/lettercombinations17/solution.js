/**
 * @param {string} digits
 * @return {string[]}
 */
const letterCombinations = function (digits) {
    let map = new Map([
        ["2", ["a", "b", "c"]],
        ["3", ["d", "e", "f"]],
        ["4", ["g", "h", "i"]],
        ["5", ["j", "k", "l"]],
        ["6", ["m", "n", "o"]],
        ["7", ["p", "q", "r", "s"]],
        ["8", ["t", "u", "v"]],
        ["9", ["w", "x", "y", "z"]]
    ]);
    let n = digits.length;
    let ret = [];
    if (n == 0) return ret;
    dfs(0, []);
    return ret;

    function dfs(u, s) {
        if (u == n) {
            ret.push(s.join(""));
            return;
        }
        let chars = map.get(digits[u]);
        for (let c of chars) {
            s.push(c);
            dfs(u + 1, s);
            s.pop();
        }
    }
};
