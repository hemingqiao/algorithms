/* 太难受了，用JS写树的代码，完全是硬码出来的，参数没有类型太难受了，难受，这个的时间效率还可以，击败了99 */
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

const zigzagLevelOrder = function (root) {
    if (root == null) return [];
    let res = [];
    let depth = 0;

    function dfs(root, depth, res) {
        if (root == null) return;
        if (depth < res.length) {
            if (depth % 2 === 0) {
                res[depth].push(root.val);
            } else {
                res[depth].unshift(root.val);
            }
        } else {
            res[depth] = [root.val];
        }

        depth++;
        dfs(root.left, depth, res);
        dfs(root.right, depth, res);
    }

    dfs(root, 0, res);
    return res;
}