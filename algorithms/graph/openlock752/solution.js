
/**
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */
const openLock = function(deadends, target) {
    let start = "0000";
    if (start == target) return 0;
    let set = new Set(deadends);
    if (set.has(start)) return -1;
    let dist = new Map(), queue = [];
    queue.push(start);
    dist.set(start, 0);
    while (queue.length) {
        let t = queue.shift();
        for (let i = 0; i < 4; i++) {
            for (let j = -1; j <= 1; j += 2) {
                let state = t;
                state =
                    state.slice(0, i) +
                    String.fromCharCode((state[i].charCodeAt(0) - 48 + j + 10) % 10 + 48) +
                    state.slice(i + 1);
                if (!dist.has(state) && !set.has(state)) {
                    dist.set(state, dist.get(t) + 1);
                    if (state == target) return dist.get(state);
                    queue.push(state);
                }
            }
        }
    }
    return -1;
};

const openLock1 = function(deadends, target) {
    let start = "0000";
    if (start == target) return 0;
    let set = new Set(deadends);
    if (set.has(start)) return -1;
    let dist = new Map(), queue = [];
    queue.push(start);
    dist.set(start, 0);
    while (queue.length) {
        let t = queue.shift();
        for (let i = 0; i < 4; i++) {
            for (let j = -1; j <= 1; j += 2) {
                let state = t.split("");
                state[i] = (+state[i] + j + 10) % 10;
                let s = state.join("");
                if (!dist.has(s) && !set.has(s)) {
                    dist.set(s, dist.get(t) + 1);
                    if (s == target) return dist.get(s);
                    queue.push(s);
                }
            }
        }
    }
    return -1;
};

let deadends = ["0201","0101","0102","1212","2002"], target = "0202";
let res = openLock(deadends, target);
console.log(res);
