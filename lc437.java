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
    HashMap<Long, Integer> h = new HashMap<>();

    int count = 0;
    int k;

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0L);
        return count;
    }

    public void preorder(TreeNode node, long currsum) {
        if (node == null) return;

        currsum += node.val;

        if (currsum == k) {
            count++;
        }

        count += h.getOrDefault(currsum - k, 0);

        h.put(currsum, h.getOrDefault(currsum, 0) + 1);

        preorder(node.left, currsum);
        // process right subtree
        preorder(node.right, currsum);

        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        h.put(currsum, h.get(currsum) - 1);
    }

}