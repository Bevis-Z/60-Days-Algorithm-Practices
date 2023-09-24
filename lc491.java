class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (! path.isEmpty() && path.get(path.size() -1) > nums[i] || used.contains(nums[i])) {
                continue;
            } 
            used.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();    
            
        } 
    }
}