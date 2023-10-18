class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }

        return IntStream.of(nums).sum();
    }
}

// Ready for improve