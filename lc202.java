class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int result = 0; 
        int temp;       
        while (n != 0) {
            temp = n % 10;
            result += temp * temp;
            n /= 10;
        }
        return result;
    }
}