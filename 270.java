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
    int sum = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        travse(root, target);
        return sum;
    }

    void travse(TreeNode root, double target) {
        if (root == null) return;
        if (root.val < target) {
            if (Math.abs(root.val - target) < Math.abs(sum - target)){
                sum = root.val;
                
            }
            travse(root.right, target);
        }
        if (root.val >= target) {
            travse(root.left, target);
            if (Math.abs(root.val - target) < Math.abs(sum - target)){
                sum = root.val;
                
            }    
        }
    } 
}