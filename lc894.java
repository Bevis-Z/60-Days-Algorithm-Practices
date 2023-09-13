import java.util.LinkedList;
import java.util.List;

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
    List<TreeNode>[] memo;


    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new LinkedList<>();
        memo = new LinkedList[n + 1];
        return build(n);
    }
    public List<TreeNode> build(int n) {
        List <TreeNode> res = new LinkedList<>();
        if ( n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (memo[n] != null) return memo[n];
        
        for (int i = 1; i < n; i += 2) {
            int j = n - i - 1;
            List<TreeNode> left = build(i);
            List<TreeNode> right = build(j);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }

        }
        memo[n] = res;
        return res;
    }
}