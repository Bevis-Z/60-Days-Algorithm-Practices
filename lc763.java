class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            edge[chars[i] - 'a'] = i;

        }
        int left = -1;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, edge[chars[i] - 'a']);
            if(right == i) {
                res.add(i - left);
                left = i;
            }
        }
        return res;
    }
}cloud practitioner 