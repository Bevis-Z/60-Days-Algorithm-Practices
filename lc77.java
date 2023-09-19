import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 1);
        return result;
    }

    void combine(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combine(n, k, i + 1);
            path.removeLast();
        }
    }
}