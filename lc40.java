import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean[] visited;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        Arrays.fill(visited, false);
        backtracking(candidates, target, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            visited[i] = true;
            sum += candidates[i];
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            visited[i] = false;
            path.removeLast();
        }
    }

}