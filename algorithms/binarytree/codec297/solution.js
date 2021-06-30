
class TreeNode {
    constructor(val) {
        this.val = val;
        this.left = this.right = null;
    }
}

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
const serialize = function(root) {
    if (root == null) return "#";
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
const deserialize = function(data) {
    console.log(data);
    let queue = data.split(",");
    return helper(queue);
};

const helper = function (queue) {
    let node = queue.shift();
    if (node == "#") return null;
    let root = new TreeNode(+node);
    // 数组是引用传递的，queue中的元素会逐渐减少
    root.left = helper(queue);
    root.right = helper(queue);
    return root;
}

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
