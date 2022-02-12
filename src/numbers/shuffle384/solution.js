{
    // 284ms

    /**
     * @param {number[]} nums
     */
    const Solution = function (nums) {
        this.nums = nums;
    };

    /**
     * Resets the array to its original configuration and return it.
     * @return {number[]}
     */
    Solution.prototype.reset = function () {
        return this.nums;
    };

    /**
     * Returns a random shuffling of the array.
     * @return {number[]}
     */
    Solution.prototype.shuffle = function () {
        let copy = this.nums.slice();
        let n = copy.length;
        while (n) {
            let r = Math.random() * n-- | 0;
            [copy[r], copy[n]] = [copy[n], copy[r]];
        }
        return copy;
    };

    /**
     * Your Solution object will be instantiated and called as such:
     * var obj = new Solution(nums)
     * var param_1 = obj.reset()
     * var param_2 = obj.shuffle()
     */
}

{
    // 260ms

    /**
     * @param {number[]} nums
     */
    const Solution = function (nums) {
        this.nums = nums;
        this.val = [...this.nums];
    };

    /**
     * Resets the array to its original configuration and return it.
     * @return {number[]}
     */
    Solution.prototype.reset = function () {
        return this.nums;
    };

    /**
     * Returns a random shuffling of the array.
     * @return {number[]}
     */
    Solution.prototype.shuffle = function () {
        let n = this.val.length;
        while (n) {
            let r = Math.random() * n-- | 0;
            [this.val[r], this.val[n]] = [this.val[n], this.val[r]];
        }
        return this.val;
    };

    /**
     * Your Solution object will be instantiated and called as such:
     * var obj = new Solution(nums)
     * var param_1 = obj.reset()
     * var param_2 = obj.shuffle()
     */
}
