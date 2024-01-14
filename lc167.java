class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int slow = 0;
        int fast = numbers.length - 1;
        while (slow < fast) {
            if (numbers[slow] + numbers[fast] == target){
                res[0] = slow + 1;
                res[1] = fast + 1;
                return res;
            } else if (numbers[slow] + numbers[fast] > target) {
                fast--;
            } else {
                slow++;
            }
        }
        return null;
    }
}