const candy = function (ratings) {
    if (ratings === null) return 0;
    let size = ratings.length;
    if (size < 2) return size;
    let nums = Array(size).fill(1);
    for (let i = 0; i < ratings.length - 1; i++) {
        if (ratings[i] < ratings[i + 1]) {
            nums[i + 1] = nums[i] + 1;
        }
    }
    for (let j = size - 1; j >= 1; j--) {
        if (ratings[j - 1] > ratings[j]) {
            nums[j - 1] = Math.max(nums[j - 1], nums[j] + 1);
        }
    }
    return nums.reduce((prev, next) => prev + next, 0); // 不使用reduce时间效率可能会好一些
}