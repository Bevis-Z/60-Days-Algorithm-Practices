import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> tree = new HashMap<>();
    int sum = 0;
    public int pathSum(int[] nums) {
        for (int code : nums) {
            int value = code % 10;
            code = code / 10;
            tree.put(code, value);
        }

        int rootCode = nums[0] / 10;
        traverse(rootCode, 0);
        return sum;

    }


    void traverse(int code, int path) {
        if(!tree.containsKey(code)) return;
        int value = tree.get(code);
        int[] pos = decode(code);
        int depth = pos[0];
        int id = pos[1];
        int leftCode = encode(depth + 1, 2 * id - 1);
        int rightCode = encode(depth + 1, id * 2);

        if (!tree.containsKey(leftCode) && !tree.containsKey(rightCode)) {
            sum += path + value;
        }

        traverse(leftCode, path + value);
        traverse(rightCode, path + value);

        
    }

    int encode(int depth, int id) {
        return 10 * depth + id;
    }

    int[] decode(int code) {
        return new int[]{code / 10, code % 10};
    }
}