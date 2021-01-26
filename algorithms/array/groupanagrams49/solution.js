
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  if (strs === null || strs.length === 0) return [];
  let res = [];
  const map = new Map();
  for (let e of strs) {
    let temp = Array(26).fill(0);
    for (let c of e) {
      temp[c.charCodeAt(0) - "a".charCodeAt(0)]++;
    }
    debugger
    let key = temp.join(" ");
    if (!map.has(key)) {
      map.set(key, []);
    }
    map.get(key).push(e);
  }
  return [...map.values()];
};

let strs = ["bdddddddddd", "bbbbbbbbbbc"];
let res = groupAnagrams(strs);
console.log(res);

var groupAnagrams1 = function(strs) {
  if (strs === null || strs.length === 0) return [];
  let res = [];
  const map = new Map();
  for (let e of strs) {
    let temp = e.split("").sort((a, b) => a > b ? a == b ? 0 : 1 : -1);
    let key = temp.join("");
    if (!map.has(key)) {
      map.set(key, []);
    }
    map.get(key).push(e);
  }
  return [...map.values()];
};
