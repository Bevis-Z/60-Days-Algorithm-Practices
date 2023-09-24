class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        backtrack(nums, path);
        return ans;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            } 
            path.add(nums[i]);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}