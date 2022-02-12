
/**
 * @param {string} s
 * @return {number}
 */
// const countPalindromicSubsequence = function(s) {
//     let ss = s.split("");
//     let set = new Set();
//     let cnt = 0;
//     dfs(ss, 0, []);
//     return cnt;
//
//     function dfs(s, p, str) {
//         if (str.length >= 3) {
//             if (str[0] == str[2] && !set.has(str.join(""))) {
//                 ++cnt;
//                 set.add(str.join(""));
//             }
//             return;
//         }
//         for (let i = p; i < s.length; i++) {
//             str.push(s[i]);
//             dfs(s, i + 1, str);
//             str.pop();
//         }
//     }
// };


// WA
const countPalindromicSubsequence = function(s) {
    let ss = s.split("").sort();
    let used = Array(ss.length).fill(false);
    let cnt = 0;
    dfs(ss, []);
    return cnt;

    function dfs(s, str) {
        if (str.length >= 3) {
            if (str[0] == str[2]) {
                ++cnt;
                console.log(str);
            }
            return;
        }
        for (let i = 0; i < s.length; i++) {
            if (used[i]) continue;
            if (i && ss[i] == ss[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            str.push(s[i]);
            dfs(s, str);
            str.pop();
            used[i] = false;
        }
    }
};

console.log(countPalindromicSubsequence("bbcbaba"));
