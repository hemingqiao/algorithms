/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  let ret = [...traversal(root)];
  return ret;

  function* traversal(root) {
    if (!root) return;
    yield root.val;
    yield* traversal(root.left);
    yield* traversal(root.right);
  }
};

/*
先序、中序和后序遍历都可以使用生成器。
 */
