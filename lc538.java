class Solution {
    public TreeNode convertBST(TreeNode root) {
        travse(root);
        return root;
    }
    int sum = 0;
    void travse(TreeNode root) {
        if (root == null) return;
        travse(root.right);
        sum += root.val;
        root.val = sum;
        travse(root.left);
    }
}