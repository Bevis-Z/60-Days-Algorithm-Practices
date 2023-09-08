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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        travse(root, 0, u.val);
        return res;
    }
    int targetDepth = -1;
    TreeNode res = null;
    void travse(TreeNode root, int curDepth, int targetVal) {
        if (root == null || res != null) return;
        if (root.val == targetVal) {
            targetDepth = curDepth;
        } else if (curDepth == targetDepth) {
            res = root;
            return;
        }
        travse(root.left, curDepth + 1, targetVal);
        travse(root.right, curDepth + 1, targetVal);
    }
}