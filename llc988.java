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
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    // 遍历过程中的路径
    StringBuilder path = new StringBuilder();
    String res = null;

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 找到叶子结点，比较字典序最小的路径
            // 结果字符串是从叶子向根，所以需要反转
            path.append((char) ('a' + root.val));
            path.reverse();

            String s = path.toString();
            if (res == null || res.compareTo(s) > 0) {
                // 如果字典序更小，则更新 res
                res = s;
            }

            // 恢复，正确维护 path 中的元素
            path.reverse();
            path.deleteCharAt(path.length() - 1);
            return;
        }
        // 前序位置
        path.append((char) ('a' + root.val));

        traverse(root.left);
        traverse(root.right);

        // 后序位置
        path.deleteCharAt(path.length() - 1);
    }
}
