
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        travse(root.left, root.right);    
    }

    void travse(Node node1, Node node2){
        if(node1 == null || node2 == null) return;
        node1.next = node2;
        travse(node1.left, node1.right);
        travse(node2.left, node2.right);
        travse(node1.right, node2.left);

}
}
