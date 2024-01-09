class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) right--;
                if (sum < 0) left++;
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}