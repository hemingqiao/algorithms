
class Node {
  prev = null;
  next = null;
  key = null;
  value = null;

  constructor(prev, key, value, next) {
    this.prev = prev;
    this.key = key;
    this.value = value;
    this.next = next;
  }
}

/**
 * @param {number} capacity
 */
const LRUCache = function(capacity) {
  this.map = new Map();
  this.head = new Node(null, -1, -1, null);
  this.tail = new Node(null, -1, -1, null);
  this.head.next = this.tail;
  this.tail.prev = this.head;

  this.capacity = capacity;
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
  if (this.map.has(key)) {
    let node = this.map.get(key);
    let ret = node.value;
    this.unlink(node);
    this.move(node);
    return ret;
  }
  return -1;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
  if (this.map.has(key)) {
    let node = this.map.get(key);
    node.value = value;
    this.unlink(node);
    this.move(node);
  } else {
    let newNode = new Node(null, key, value, null);
    this.map.set(key, newNode);
    this.move(newNode);
    if (this.map.size > this.capacity) {
      this.map.delete(this.tail.prev.key);
      this.unlink(this.tail.prev);
    }
  }
};

LRUCache.prototype.unlink = function (node) {
  node.prev.next = node.next;
  node.next.prev = node.prev;
}

LRUCache.prototype.move = function (node) {
  node.next = this.head.next;
  this.head.next.prev = node;
  this.head.next = node;
  node.prev = this.head;
}

let l = new LRUCache(2);
l.put(1, 1);
l.put(2, 2);
l.get(1);
l.put(3, 3);
console.log(l.get(2));

