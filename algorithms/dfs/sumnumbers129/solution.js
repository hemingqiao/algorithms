function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

const sumNumbers = function (root) {
    let res = 0;
    if (root === null) return 0;
    let path = [root.val];
    dfs(root, path);
    return res;

    function dfs(root, path) {
        if (root.left === null && root.right === null) res += add(path);
        if (root.left) {
            path.push(root.left.val);
            dfs(root.left, path);
            path.pop();
        }
        if (root.right) {
            path.push(root.right.val);
            dfs(root.right, path);
            path.pop();
        }
    }

    function add(arr) {
        let temp = 0;
        for (let i = 0; i < arr.length; i++) {
            temp = temp * 10 + arr[i];
        }
        return temp;
    }
}

let root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
let result = sumNumbers(root)
console.log(result);