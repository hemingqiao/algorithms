const N = 1e6;
const BOUNDARY = N;
const INF = 1e10;

// 正负随机数混合
const generateRandomArray = (size, boundary) => {
    let ret = [];
    for (let i = 0; i < size; i++) {
        let sign = Math.random() < 0.2 ? -1 : 1;
        ret.push(sign * (Math.random() * boundary | 0));
    }
    return ret;
};

const testArr = generateRandomArray(N, BOUNDARY);
const copy1 = testArr.slice();
const copy2 = testArr.slice();
const copy3 = testArr.slice();

// O(n^3)
// 卡 200/209
function maximumSubarray(nums) {
    let ans = -INF, n = nums.length;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            let sum = 0;
            for (let k = j; k <= i; k++) {
                sum += nums[k];
            }
            ans = Math.max(ans, sum);
        }
    }
    return ans;
}

// O(n^2)
// 卡 206/209
function maximumSubarray1(nums) {
    let ans = -INF, n = nums.length;
    let s = [0];
    for (let i = 1; i <= n; i++) {
        s.push(s[i - 1] + nums[i - 1]);
    }
    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            ans = Math.max(ans, s[i + 1] - s[j]);
        }
    }
    return ans;
}


// O(nlog(n))
function maximumSubarray2(nums) {
    return calc(0, nums.length - 1, nums);

    function calc(l, r, nums) {
        if (l >= r) return nums[l];
        let mid = l + r >> 1;
        let lmax = nums[mid], lsum = 0, rmax = nums[mid + 1], rsum = 0;
        for (let i = mid; i >= l; i--) {
            lsum += nums[i];
            lmax = Math.max(lmax, lsum);
        }
        for (let i = mid + 1; i <= r; i++) {
            rsum += nums[i];
            rmax = Math.max(rmax, rsum);
        }
        return Math.max(lmax + rmax, Math.max(calc(l, mid, nums), calc(mid + 1, r, nums)));
    }
}

// O(n)
function maximumSubarray3(nums) {
    let ans = -INF;
    for (let i = 0, last = 0; i < nums.length; i++) {
        last = nums[i] + Math.max(last, 0);
        ans = Math.max(ans, last);
    }
    return ans;
}

console.log(N);
// console.time("1");
// console.log(maximumSubarray(testArr));
// console.timeEnd("1");
// console.time("2");
// console.log(maximumSubarray1(copy1));
// console.timeEnd("2");
console.time("3");
console.log(maximumSubarray2(copy2));
console.timeEnd("3");
console.time("4");
console.log(maximumSubarray3(copy3));
console.timeEnd("4");

for (let i = 0; i < n; i++) {
    // some operation
}

for (let i = 0, j = nums.length - 1; i < j; i++) {
    while (i < j && nums[i] + nums[j] == target) j--;
    if (nums[i] + nums[j] == target) {
        return [i, j];
    }
}

