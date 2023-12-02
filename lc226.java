
class Solution {
    public TreeNode invertTree(TreeNode root) {
            
            travse(root);
            return root;
    }

    void travse (TreeNode root){
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        travse(root.left);
        travse(root.right);

    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

   
}