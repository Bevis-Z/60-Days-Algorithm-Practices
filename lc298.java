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
    public int longestConsecutive(TreeNode root) {
        travse(root, 1, Integer.MIN_VALUE);
        return maxLen;
    }

    int maxLen = 0;
    
    void travse(TreeNode root,int len, int parentVal){
        if (root == null) return;
        if (parentVal + 1 == root.val) {
            len ++;
        } else {
            len = 1;
        }
        maxLen = Math.max(maxLen, len);
        travse(root.left, len, root.val);
        travse(root.right, len, root.val);
    }
};