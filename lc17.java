class Solution {

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        // String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, 0);
        return list;
    }

    StringBuilder temp = new StringBuilder();

    public void backTracking (String digits, int num) {
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
} 