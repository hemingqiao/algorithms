/** js解法，找出所有从根节点到叶子节点的路径，在利用join方法返回string **/


function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

const binaryTreePaths = function (root) {
    let res = [];
    if (root == null) return [];
    dfs(root, []);
    return res;

    function dfs(root, arr) {
        if (root === null) return;
        arr.push(root.val); // 将当前节点加入路径
        if (root.left === null && root.right === null) { // 如果到达叶子节点，将完整路径加入res数组
            res.push(arr.join("->"));
        }
        dfs(root.left, arr.concat()); // 因为数组是引用传递，所以这里使用concat返回一个新的数组
        dfs(root.right, arr.concat());
    }
}
