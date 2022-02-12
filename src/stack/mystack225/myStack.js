/** 使用队列模拟栈的行为 **/

/**
 * Initialize your data structure here.
 */
var MyStack = function() {
    this.queue = [];
};

/**
 * Push element x onto stack.
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function(x) {
    this.queue.push(x);
    for (let i = 0; i < this.queue.length - 1; i++) {
        this.queue.push(this.queue.shift());
    }
};

/**
 * Removes the element on top of the stack and returns that element.
 * @return {number}
 */
MyStack.prototype.pop = function() {
    return this.queue.shift();
};

/**
 * Get the top element.
 * @return {number}
 */
MyStack.prototype.top = function() {
    // 因为数组不支持取得头部元素但不删除头部元素，所以只好将头部元素出队，然后再入队
    let top = this.queue.shift();
    this.queue.push(top);
    return top;
};

/**
 * Returns whether the stack is empty.
 * @return {boolean}
 */
MyStack.prototype.empty = function() {
    return this.queue.length === 0;
};

let test = new MyStack();
test.push(1);
test.push(2);
let res = test.top();
console.log(res);
let res1 = test.pop();
console.log(res1);
console.log(test.empty());


