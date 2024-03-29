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
    public List<Integer> getLonelyNodes(TreeNode root) {
        travse(root);
        return res;
    }

    List<Integer> res = new LinkedList<>();
    
    void travse(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right != null) {
            res.add(root.right.val);
        }
        if (root.left != null && root.right == null) {
            res.add(root.left.val);
        }

        travse(root.left);
        travse(root.right);
    }
}