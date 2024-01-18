class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 2) {
                swap(nums, left, right);
                right--;
            } else if (nums[left] == 0) {
                swap(nums, left, zero);
                zero++;
                left++;
            } else {
                left++;
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}