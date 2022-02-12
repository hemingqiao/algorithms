/**
 * @param {number[]} A
 * @param {number[]} B
 * @param {number[]} C
 * @param {number[]} D
 * @return {number}
 */
const fourSumCount = function(A, B, C, D) {
    const map = new Map();
    for (let a of A) {
        for (let b of B) {
            map.set(a + b, (map.get(a + b) || 0) + 1);
        }
    }
    let count = 0;
    for (let c of C) {
        for (let d of D) {
            if (map.has(-c - d)) count += map.get(-c - d);
        }
    }
    return count;
};
