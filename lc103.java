class Solution {
    int max = 0;

    int depth = 0;
    
    public int maxDepth(TreeNode root) {
        travser(root);
        return max;
    }

    void travser(TreeNode root){
        if(root == null) return;
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            max = Math.max(max, depth);
        }        
        travser(root.left);
        travser(root.right);
        depth--;
    }
    
}