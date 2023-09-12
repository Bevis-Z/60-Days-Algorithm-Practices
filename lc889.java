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
    HashMap<Integer, Integer> postIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i ++) {
            postIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd) return null;
        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        int index = postIndex.get(leftRootVal);
        int leftSize = index - postStart + 1;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }
}