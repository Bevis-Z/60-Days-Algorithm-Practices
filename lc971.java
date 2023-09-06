import java.util.Arrays;
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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        travse(root);
        if (canFlip) return res;
        return Arrays.asList(-1);
    }

    List<Integer> res = new LinkedList<>();
    int i = 0;
    int [] voyage;
    boolean canFlip = true;
    
    void travse(TreeNode root) {
        if (root == null || !canFlip) {
            return;
        }
        if (root.val != voyage[i++]) {
            canFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            res.add(root.val);
        }
        travse(root.left);
        travse(root.right);

    }
}