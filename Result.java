import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'maximumPrioritySum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY priority
     *  2. INTEGER x
     *  3. INTEGER y
     */

    public static long maximumPrioritySum(List<Integer> priority, int x, int y) {
    // Write your code here
        int n = priority.size();
        long[] dp = new long[n+1];
        dp[0]=0;
        dp[1]=priority.get(0);
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i-1] + priority.get(i-1), dp[i-2] + priority.get(i-2));
        }
        return dp[n];


    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int priorityCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> priority = new ArrayList<>();

        for (int i = 0; i < priorityCount; i++) {
            int priorityItem = Integer.parseInt(bufferedReader.readLine().trim());
            priority.add(priorityItem);
        }

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int y = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.maximumPrioritySum(priority, x, y);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
