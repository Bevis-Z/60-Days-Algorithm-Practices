class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1 || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int cover = 0;
        int maxCover = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCover = Math.max(maxCover, i + nums[i]);
            if (maxCover >= nums.length - 1) {
                return count + 1;
            }
            if (i == cover) {
                count++;
                cover = maxCover;
            }

        }
        return count;
    }
}