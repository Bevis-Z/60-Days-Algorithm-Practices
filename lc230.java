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
    public int kthSmallest(TreeNode root, int k) {
        travse(root, k);
        return res;
    }
    
    int res = 0;
    int count = 0;
    void travse(TreeNode root, int k){
        if(root == null) return;
        travse(root.left, k);
        count++;
        for(int i = 0; i < k; i++){
            if(count == k){
                res = root.val;
                return;
            }
        }
        travse(root.right, k);
        
    }
}