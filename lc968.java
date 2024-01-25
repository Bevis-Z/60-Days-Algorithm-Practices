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
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (cameraCover(root) == 0) {
            res++;
        }
        return res;
    }
    public int cameraCover(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = cameraCover(root.left);
        int right = cameraCover(root.right);
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right ==0) {
            res++;
            return 1;
        } else {
            return 2;
        }
    }
}