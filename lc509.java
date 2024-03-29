class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int a = 0, b = 1;
        int result;
        for(int i = 2; i <= n; i++){
            result = a + b;
            a = b;
            b = result;
        }
        return b;
    }
}
