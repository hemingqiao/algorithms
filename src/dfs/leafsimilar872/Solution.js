const leafSimilar = function (root1, root2) {
    const leaf1 = dfs(root1), leaf2 = dfs(root2);
    while (true) {
        const val1 = leaf1.next().value;
        const val2 = leaf2.next().value;
        if (val1 !== val2) return false;
        if (val1 === undefined) break;
    }
    return true;

    function* dfs(root) {
        const stack = [root];
        while (stack.length) {
            const node = stack.pop();
            let flag = true;

            if (node.right) {
                flag = false;
                stack.push(node.right);
            }

            if (node.left) {
                flag = false;
                stack.push(node.left);
            }

            if (flag) yield node.val;
        }
    }
}

function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
}