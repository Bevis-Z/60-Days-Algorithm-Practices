class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String target : dictionary) {
            int l1 = longestWord.length();
            int l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            } else {
                if(isSub(s, target)) {
                    longestWord = target; 
                }
            }
        }
        return longestWord;
    }

    private boolean isSub(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
        i++;
        }
        return j == target.length();
    }
}