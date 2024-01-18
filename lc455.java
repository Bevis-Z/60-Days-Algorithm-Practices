class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int gl = g.length - 1;
        int sl = s.length - 1;
        while (gl >= 0) {
            if (sl >= 0 && g[gl] <= s[sl]) {
                result++;
                sl--;
            }
            gl--;
        }
        return result;
    }
}