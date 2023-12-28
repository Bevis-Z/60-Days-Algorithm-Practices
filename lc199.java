import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<integer> list = new LinkedList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.peek().val);
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
            
        }

        return list;
    }
}