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
    public TreeNode bstToGst(TreeNode root) {
        travse(root);
        return root;
    }
    int sum = 0;
    void travse(TreeNode root) {
        if (root == null) return;
        travse(root.right);
        sum += root.val;
        root.val = sum;
        travse(root.left);
    }
}