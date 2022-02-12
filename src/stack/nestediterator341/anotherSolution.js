// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
function NestedInteger() {

  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  // @return {boolean}
  this.isInteger = function () {

  }

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  // @return {integer}
  this.getInteger = function () {

  }

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  // @return {NestedInteger[]}
  this.getList = function () {

  }
}


/**
 * @constructor
 * @param {NestedInteger[]} nestedList
 */
var NestedIterator = function(nestedList) {
  const list = [];
  const dfs = (nestedList, i = 0, NestedInteger) => {
    while (NestedInteger = nestedList[i++]) {
      NestedInteger.isInteger() ? list.push(NestedInteger.getInteger()) : dfs(NestedInteger.getList());
    }
  }
  dfs(nestedList);
  this.list = list;
  this.index = 0;
};


/**
 * @this NestedIterator
 * @returns {boolean}
 */
NestedIterator.prototype.hasNext = function() {
  return this.index < this.list.length;
};

/**
 * @this NestedIterator
 * @returns {integer}
 */
NestedIterator.prototype.next = function() {
  return this.list[this.index++];
};


