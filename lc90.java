class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracking(nums, 0);
        return result;

    }

    private void backTracking (int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }


}