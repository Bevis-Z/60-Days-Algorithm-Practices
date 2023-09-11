import java.util.HashSet;

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
class FindElements {
    HashSet<Integer> set = new HashSet<>();


    public FindElements(TreeNode root) {
        root.val = 0;
        traverse(root, 0);
    }

    void traverse(TreeNode root, int val) {
        if (root == null) return;
        root.val = val;
        set.add(val);
        traverse(root.left, 2 * val + 1);
        traverse(root.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return set.contains(target);    
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */