class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        chars = removeExtraSpace(chars);
        reverse(chars, 0, chars.length - 1);
        reverseEachWorld(chars);
        return new String(chars);
    }

    private char[] removeExtraSpace(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0) {
                    chars[slow] = ' ';
                    slow++;
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow); 
        return newChars;
    }

    private void reverseEachWorld(char[] chars) {
        int start = 0;
        //end <= s.length() 这里的 = ，是为了让 end 永远指向单词末尾后一个位置，这样 reverse 的实参更好设置
        for (int end = 0; end <= chars.length; end++) {
            // end 每次到单词末尾后的空格或串尾,开始反转单词
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}