import java.util.HashMap;

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
    HashMap<Integer, Integer> preSumCount = new HashMap<>();

    int pathSum, targetSum;
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        this.pathSum = 0;
        this.targetSum = targetSum;
        this.preSumCount.put(0, 1);
        travse(root);
        return res;

    }

    void travse(TreeNode root) {
        if (root == null) return;

        pathSum += root.val;
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        travse(root.left);
        travse(root.right);

        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }
}