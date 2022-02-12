/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
const kWeakestRows = function(mat, k) {
    let ret = [];
    let q = new PriorityQueue(
        mat.map((row, idx) => ({r: idx, num: row.reduce((a, b) => a + b)})),
        (a, b) => a.num == b.num ? a.r - b.r : a.num - b.num
    );
    console.log(q.heap);
    while (k--) ret.push(q.poll().r);
    return ret;
};

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
        while ((u / 2 | 0) > 0 && this.comparator(this.heap[u], this.heap[u / 2 | 0]) < 0) {
            swap(this.heap, u / 2 | 0, u);
            u >>= 1;
        }
    }

    poll() {
        let ret = this.heap[1];
        this.heap[1] = this.heap.pop();
        this.cnt--;
        this.down(1);
        return ret;
    }

    offer(x) {
        this.heap.push(x);
        this.cnt++;
        this.up(this.cnt);
    }

    peek() {
        if (this.cnt < 0) throw new Error("priority queue is empty");
        return this.heap[1];
    }

    heapify() {
        for (let i = this.cnt / 2 | 0; i; i--) {
            this.down(i);
        }
    }

    isEmpty() {
        return this.cnt <= 0;
    }

    size() {
        return this.cnt;
    }
}

console.log(
    kWeakestRows([[1, 1, 0, 0, 0], [1, 1, 1, 1, 0], [1, 0, 0, 0, 0], [1, 1, 0, 0, 0], [1, 1, 1, 1, 1]], 3)
);

{
    /**
     * @param {number[][]} mat
     * @param {number} k
     * @return {number[]}
     */
    const kWeakestRows = function(mat, k) {
        let ret = Array(k).fill(0);
        mat = mat.map((r, i) => ({row: i, num: r.reduce((a, b) => a + b)}));
        let q = new PriorityQueue([], (a, b) => a.num == b.num ? b.row - a.row : b.num - a.num);
        for (let i = 0; i < mat.length; i++) {
            q.offer(mat[i]);
            if (q.size() > k) q.poll();
        }
        while (!q.isEmpty()) ret[--k] = q.poll().row;
        return ret;
    };
}
