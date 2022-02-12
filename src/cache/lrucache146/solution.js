
/*
暴力遍历
 */

/**
 * @param {number} capacity
 */
const LRUCache = function(capacity) {
  this.container = [];
  this.capacity = capacity;
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
  for (let i = 0; i < this.container.length; i++) {
    let entry = this.container[i];
    if (entry.key === key) {
      let val = entry.value;
      this.container.splice(i, 1);
      this.container.unshift(entry);
      return val;
    }
  }
  return -1;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
  let index = this.container.findIndex(item => item.key === key);
  if (index >= 0) {
    this.container.splice(index, 1);
    this.container.unshift({key, value});
  } else {
    this.container.unshift({key, value});
  }
  if (this.container.length > this.capacity) {
    this.container.pop();
  }
};

let l = new LRUCache(2);
l.put(2, 1);
l.put(2, 2);
console.log(l.get(2));
