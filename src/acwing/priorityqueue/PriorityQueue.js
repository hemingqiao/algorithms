function swap(q, i, j) {
    let temp = q[i];
    q[i] = q[j];
    q[j] = temp;
}

function noop() {
}

class PriorityQueue {
    heap = [0];
    size = 0;
    comparator = noop;

    constructor(initialArray = [], comparator = (a, b) => a - b) {
        this.heap = this.heap.concat(initialArray);
        this.size = this.heap.length;
        this.comparator = comparator;
        for (let i = this.size / 2 | 0; i; i--) {
            this.down(i);
        }
    }

    /*down(u) {
        let t = u;
        if (u * 2 <= this.cnt && this.heap[u * 2] < this.heap[t]) t = u * 2;
        if (u * 2 + 1 <= this.cnt && this.heap[u * 2 + 1] < this.heap[t]) t = u * 2 + 1;
        if (t !== u) {
            swap(this.heap, t, u);
            this.down(t);
        }
    }*/
    down(u) {
        let t = u;
        if (u * 2 <= this.size && this.comparator(this.heap[u * 2], this.heap[t]) < 0) t = u * 2;
        if (u * 2 + 1 <= this.size && this.comparator(this.heap[u * 2 + 1], this.heap[t]) < 0) t = u * 2 + 1;
        if (t !== u) {
            swap(this.heap, t, u);
            this.down(t);
        }
    }

    /*up(u) {
        while ((u / 2 | 0) > 0 && this.heap[u / 2 | 0] > this.heap[u]) {
            swap(this.heap, u / 2 | 0, u);
            u = u / 2 | 0;
        }
    }*/

    up(u) {
        while ((u / 2 | 0) > 0 && this.comparator(this.heap[u], this.heap[u / 2 | 0]) < 0) {
            swap(this.heap, u / 2 | 0, u);
            u >>= 1;
        }
    }

    poll() {
        let ret = this.heap[1];
        this.heap[1] = this.heap.pop();
        this.size--;
        this.down(1);
        return ret;
    }

    offer(x) {
        this.heap.push(x);
        this.up(this.size);
        this.size++;
    }
    
    peek() {
        if (this.size < 2) throw new Error("priority queue is empty");
        return this.heap[1];
    }
}

/*let test = [3, 4, 1, 5, 2];
let q = new PriorityQueue(test);
let m = test.length;
while (m--) {
    console.log(q.poll());
}*/

let q = new PriorityQueue();
q.offer(5);
q.offer(3);
q.offer(1);
console.log(q.poll());
console.log(q.poll());
console.log(q.poll());
