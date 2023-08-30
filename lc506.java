class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}

// Solution 2: Dynamic Programming with O(1) Space
class Solution {
    public int fib(int n) {
        if(n==0 || n==1) return n;

        int a = 0, b =1;
        int result;
        for(int i = 2; i <= n; i++){
            result = a + b;
            a = b;
            b = result;
        }
        return b;
    }
}