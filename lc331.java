class Solution {
    public boolean isValidSerialization(String preorder) {
        int edge = 1;
        // String[] node; 
        for (String node : preorder.split(",")) {

            if (node.equals("#"")) {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;

            }
        }
        return edge == 0;

    }
}