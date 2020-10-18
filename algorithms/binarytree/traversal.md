# 二叉树的三种遍历

设根节点为root，左子树为left，右子树为right。

## 先序遍历

root -> left -> right

## 中序遍历

left -> root -> right

## 后序遍历

left -> right -> root

## BFS(宽度优先遍历)

宽度优先遍历的示意图如下：
![BFS](https://pic.leetcode-cn.com/1601255715-zYNzNP-image.png)

代码实现如下：
```java
    class LevelOrder {
        public void levelOrder(TreeNode tree) {
            if (tree == null)
                return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);//相当于把数据加入到队列尾部
            while (!queue.isEmpty()) {
                //poll方法相当于移除队列头部的元素
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }    
```