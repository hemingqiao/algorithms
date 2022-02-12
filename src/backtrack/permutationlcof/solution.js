
/**
 * @param {string} s
 * @return {string[]}
 */
const permutation = function(s) {
    let chars = s.split("").sort();
    let n = chars.length;
    let used = Array(n).fill(false), ret = [];
    dfs(chars, "", ret, used);
    return ret;
};

function dfs(s, path, ret, used) {
    if (path.length >= s.length) {
        ret.push(path);
        return;
    }
    for (let i = 0; i < s.length; i++) {
        if (i > 0 && s[i] == s[i - 1] && !used[i - 1]) continue;
        if (used[i]) continue;
        path += s[i];
        used[i] = true;
        dfs(s, path, ret, used);
        used[i] = false;
        path = path.slice(0, -1);
    }
}

console.log(permutation("aab"));
