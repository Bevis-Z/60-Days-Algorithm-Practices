class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0);
        return result;
    }
    
    void backtracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(targetSum, k, i + 1, sum + i);
            path.removeLast();
        }
    }
}