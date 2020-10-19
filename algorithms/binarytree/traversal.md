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

## DFS(深度优先遍历)

深度优先遍历的示意图如下：

![DFS](https://s5.51cto.com/oss/202004/16/92f602a1eaa301784085b8a3c4b948c0.png)

代码实现如下：
```java
    class DFS {
        public void dfs(TreeNode tree) {
            Stack<Node> stack = new Stack<Node>();
            List<Node> result = new ArrayList<Node>();
            stack.push(root);
            while (!stack.isEmpty()) {
            	Node top = stack.pop();
            	result.add(top);
            	List<Node> children = top.getChildren();
            	if (children != null && children.size() > 0) {
            		for (int i = children.size() - 1; i >= 0; i--) {
            			stack.push(children.get(i));
            		}
            	}
            }
        }
    }   
```