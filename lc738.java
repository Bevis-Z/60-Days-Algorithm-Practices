class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int marker = digits.length;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] > digits[i + 1]) {
                marker = i + 1;
                digits[i]--;
            }
        } 
        for (int i = marker; i < digits.length; i++) {
            digits[i] = '9';
        }
        return Integer.parseInt(new String(digits));
    }
}