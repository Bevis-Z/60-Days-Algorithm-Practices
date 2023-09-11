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
    int maxDepth = 0;
    int depth = 0;
    TreeNode res = null;


    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res.val;
    }

    void traverse (TreeNode root) {
        if (root == null) return;
        
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root;
        }

        traverse(root.left);
        traverse(root.right);

        depth--;
    }
}