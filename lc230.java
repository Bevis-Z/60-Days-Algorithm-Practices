
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