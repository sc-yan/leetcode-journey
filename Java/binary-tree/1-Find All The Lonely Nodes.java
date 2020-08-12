Easy Leetcode 1469. Find All The Lonely Nodes

tags: binary tree

方法1:
用递归遍历二叉树

方法2:
非常巧妙的省略掉了复杂的判定。
方法3：
应该可以用stack的非递归方式遍历


```

/*
方法1
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void traverse(TreeNode x, List<Integer> res) {
        if(x != null) {
            if((x.left == null && x.right != null)) {
                res.add(x.right.val);
            }else if(x.left != null && x.right == null) {
                res.add((x.left.val));
            }
            traverse(x.left, res);
            traverse(x.right, res);
        }
    }
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }
}

/*
方法2
*/

public List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> nodes = new ArrayList<>();
    getLonelyNodes(root, false, nodes); // root is not lonely
    return nodes;
}

private void getLonelyNodes(TreeNode root, boolean isLonely, List<Integer> nodes) {
    if (root == null) return;
    
    if (isLonely) {
        nodes.add(root.val);
    }
    
    getLonelyNodes(root.left, root.right == null, nodes);
    getLonelyNodes(root.right, root.left == null, nodes);
}





