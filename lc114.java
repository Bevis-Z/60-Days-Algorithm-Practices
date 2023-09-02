import javax.swing.tree.TreeNode;

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
    public void flatten(TreeNode root) {
        // base case
        if(root == null) return;
        // flatten left subtree
        flatten(root.left);
        // flatten right subtree
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 将左子树作为右子树
        root.left = null;
        root.right = left;
        // 将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}