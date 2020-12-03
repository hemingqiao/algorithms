/*! *****************************************************************************
@author Heming
founded at 2020-12-03 16:45:10
created by IntelliJ IDEA
description: 341. 扁平化嵌套列表迭代器
from：https://leetcode-cn.com/problems/flatten-nested-list-iterator/
***************************************************************************** */


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
function NestedInteger(value) {
  this.list = [];
  this.val = null;
  if (Array.isArray(value)) {
    this.list = value;
  } else {
    this.val = value;
  }
  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  // @return {boolean}
  this.isInteger = function () {
    return this.val !== null && this.list.length === 0;
  }

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  // @return {integer}
  this.getInteger = function () {
    return this.val;
  }

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  // @return {NestedInteger[]}
  this.getList = function () {
    return this.list;
  }
}


/**
 * @constructor
 * @param {NestedInteger[]} nestedList
 */
var NestedIterator = function(nestedList) {
  let proto = Object.getPrototypeOf(this);
  proto.res = [];
  proto.traversal.call(this, nestedList);
  proto.res.reverse();
};


/**
 * @this NestedIterator
 * @returns {boolean}
 */
NestedIterator.prototype.hasNext = function() {
  return !!this.res.length;
};

/**
 * @this NestedIterator
 * @returns {integer}
 */
NestedIterator.prototype.next = function() {
  return this.res.pop();
};

NestedIterator.prototype.traversal = function (list) {
  let proto = Object.getPrototypeOf(this);
  for (let n of list) {
    if (n.isInteger()) {
      proto.res.push(n.getInteger());
    } else {
      proto.traversal.call(this, n.getList());
    }
  }
}

// for test
let n1 = new NestedInteger(1);
let n2 = new NestedInteger(1);
let l1 = [n1, n2];
let n3 = new NestedInteger(l1);
let n4 = new NestedInteger(2);
let n5 = new NestedInteger(1);
let n6 = new NestedInteger(1);
let l2 = [n5, n6];
let n7 = new NestedInteger(l2);
let testArray = [n3, n4, n7];
console.log(testArray);
const it = new NestedIterator(testArray);
const res = [];
while (it.hasNext()) {
  res.push(it.next());
}
console.log(res);
