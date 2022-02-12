function swap(q, i, j) {
    let temp = q[i];
    q[i] = q[j];
    q[j] = temp;
}

function noop() {
}

class PriorityQueue {
    heap = [0];
    cnt = 0;
    comparator = noop;

    constructor(initialArray = [], comparator = (a, b) => a - b) {
        this.heap = this.heap.concat(initialArray);
        this.cnt = initialArray.length;
        this.comparator = comparator;
        this.heapify();
    }

    down(u) {
        let t = u;
        if (u * 2 <= this.cnt && this.comparator(this.heap[u * 2], this.heap[t]) < 0) t = u * 2;
        if (u * 2 + 1 <= this.cnt && this.comparator(this.heap[u * 2 + 1], this.heap[t]) < 0) t = u * 2 + 1;
        if (t !== u) {
            swap(this.heap, t, u);
            this.down(t);
        }
    }

    up(u) {
        while ((u >> 1) > 0 && this.comparator(this.heap[u], this.heap[u >> 1]) < 0) {
            swap(this.heap, u / 2 | 0, u);
            u >>= 1;
        }
    }

    poll() {
        if (this.cnt <= 0) throw new Error("priority queue is empty");
        let ret = this.heap[1];
        this.cnt--;
        let tail = this.heap.pop();
        if (this.cnt > 0) {
            this.heap[1] = tail;
            this.down(1);
        }
        return ret;
    }

    offer(x) {
        this.heap.push(x);
        this.cnt++;
        this.up(this.cnt);
    }

    peek() {
        if (this.cnt <= 0) throw new Error("priority queue is empty");
        return this.heap[1];
    }

    heapify() {
        for (let i = this.cnt >> 1; i; i--) {
            this.down(i);
        }
    }

    /*heapify() {
        for (let i = 1; i <= this.cnt; i++) {
            this.up(i);
        }
    }*/

    isEmpty() {
        return this.cnt <= 0;
    }

    size() {
        return this.cnt;
    }
}

/*let test = [3, 4, 1, 5, 2];
let q = new PriorityQueue(test, (a, b) => b - a);
let m = test.length;
while (m--) {
    console.log(q.poll());
}*/

/*let q = new PriorityQueue();
q.offer(5);
q.offer(3);
q.offer(1);
console.log(q.poll());
console.log(q.poll());
console.log(q.poll());*/

function randomArray(size, boundary) {
    let ret = [];
    for (let i = 0; i < size; i++) ret.push(Math.random() * boundary | 0);
    return ret;
}

function isAscSorted(arr) {
    for (let i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) return false;
    }
    return true;
}

/*
// const test = randomArray(15, 100);
const test = randomArray(1500000, 10000000);
const testCopy = test.slice();
console.log(isAscSorted(test));
console.time("start");
let q = new PriorityQueue(test);
let ret = [];
while (!q.isEmpty()) ret.push(q.poll());
console.timeEnd("start");
console.log(isAscSorted(ret));


console.log(isAscSorted(testCopy));
console.time("original sort");
testCopy.sort((a, b) => a - b);
console.timeEnd("original sort");
console.log(isAscSorted(testCopy));
*/

/*let test = [{x: 1, y: 2}, {x: 1, y: 1}, {x: 0, y: 1}, {x: 0, y: 0}];
let q = new PriorityQueue(test, (a, b) => {
    if (a.x == b.x) return a.y - b.y;
    return a.x - b.x;
});
let ret = [];
while (!q.isEmpty()) {
    ret.push(q.poll());
}
console.log(ret);*/

/*let test = Array(100).fill(0).concat(Array(100).fill(1));
let q = new PriorityQueue(test, (a, b) => b - a);
let ret = [];
while (!q.isEmpty()) {
    ret.push(q.poll());
}
console.log(ret);*/

/*const minStoneSum = function(piles, k) {
    let q = new PriorityQueue(piles, (a, b) => b - a);
    while (k--) {
        let x = q.poll();
        q.offer(x - (x / 2 | 0));
    }
    let res = 0;
    while (!q.isEmpty()) {
        res += q.poll();
    }
    return res;
};

console.log(minStoneSum([10000], 1));*/

/*const test = randomArray(10000000, 1500000);
const copy = test.slice();
const copy1 = test.slice();

console.time("sort");
test.sort((a, b) => a - b);
console.log(test.slice(-10));
console.timeEnd("sort");

console.time("queue");
let q = new PriorityQueue(copy, (a, b) => b - a);
let ret = [], n = 10;
while (n--) ret.push(q.poll());
console.log(ret);
console.timeEnd("queue");

console.time("queue1");
let queue = new PriorityQueue();
for (let i = 0; i < copy1.length; i++) {
    queue.offer(copy1[i]);
    if (queue.size() > 10) queue.poll();
}
let a = [];
while (!queue.isEmpty()) a.push(queue.poll());
console.log(a);
console.timeEnd("queue1");*/

/*const test = randomArray(10, 100);
console.log(test);
let q = new PriorityQueue();
for (let i = 0; i < test.length; i++) {
    q.offer(test[i]);
    if (q.size() > 3) q.poll();
}
console.log(q);*/

const test = randomArray(50000000, 10000000);
const copy0 = test.slice();
const copy1 = test.slice();


console.time("heap1");
let q = new PriorityQueue(test, (a, b) => b - a);
let a = 10, res = [];
while (a--) res.push(q.poll());
console.timeEnd("heap1");
console.log(res);

console.time("quick select");
let ret = getTopK(copy0, 10);
console.timeEnd("quick select");
ret.sort((a, b) => b - a);
console.log(ret);


function getTopK(arr, k) {
    quickSelect(arr, 0, arr.length - 1, k);
    return arr.slice(0, 10);
}

function quickSelect(q, l, r, k) {
    if (l >= r) return l;
    let x = q[l], i = l - 1, j = r + 1;
    while (i < j) {
        while (q[++i] > x);
        while (q[--j] < x);
        if (i < j) swap(q, i, j);
    }
    let sl = i - l + 1;
    if (sl >= k) return quickSelect(q, l, i, k);
    return quickSelect(q, i + 1, r, k - sl);
}

console.time("quick sort");
copy1.sort((a, b) => b - a);
console.timeEnd("quick sort");
console.log(copy1.slice(0, 10).reverse());
