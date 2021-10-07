/**
 * @param {number[]} nums
 * @return {number}
 */
const thirdMax = function(nums) {
    let INF = 1e10, a = -INF, b = -INF, c = -INF;
    for (let i = 0; i < nums.length; i++) {
        let x = nums[i];
        if (x > a) c = b, b = a, a = x;
        else if (x > b && x < a) c = b, b = x;
        else if (x > c && x < b) c = x;
    }
    return c == -INF ? a : c;
};
