import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
    
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int temp = target - nums[i];
        if (map.containsKey(temp)) {
            res[1] = i;
            res[0] = map.get(temp);
            break;
        }
        map.put(nums[i], i);
    }
    return res;

}

// Solution 2: brute force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}