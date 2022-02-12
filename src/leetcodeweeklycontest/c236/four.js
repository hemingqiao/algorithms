/**
 * @param {number} m
 * @param {number} k
 */
const MKAverage = function(m, k) {
  this.m = m;
  this.k = k;
  this.container = [];
};

/**
 * @param {number} num
 * @return {void}
 */
MKAverage.prototype.addElement = function(num) {
  this.container.push(num);
};

/**
 * @return {number}
 */
MKAverage.prototype.calculateMKAverage = function() {
  if (this.container.length < this.m) return -1;
  let temp = this.container.slice(-this.m);
  temp.sort((a, b) => a - b);
  temp = temp.slice(this.k, -this.k);
  return Math.floor((temp.reduce((a, b) => a + b)) / temp.length);
};
