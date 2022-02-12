function TreeNode(val) {
   this.val = val;
   this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
  this.itr = traversal(root);

  function* traversal(root) {
    if (!root) return;
    yield* traversal(root.left);
    yield root.val;
    yield* traversal(root.right);
  }
};

/**
 * @return the next smallest number
 * @return {number}
 */
BSTIterator.prototype.next = function() {
  if (this.iteratorResult) {
    return this.iteratorResult.value;
  }
  return this.itr.next().value;
};

/**
 * @return whether we have a next smallest number
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
  this.iteratorResult = this.itr.next();
  return !this.iteratorResult.done;
};
