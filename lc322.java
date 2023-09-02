import java.lang.reflect.Array;

// leetcode 322. Coin Change
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins,
// return -1.
// You may assume that you have an infinite number of each kind of coin.
// Example 1:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Solution 1: Dynamic Programming
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1); // fill the array with amount+1

        dp[0] = 0; // base case
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1); // dp[i] = min(dp[i], dp[i-coins[j]]+1)
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


int coinChange(int[] coins, int amount) {
    // 题目要求的最终结果是 dp(amount)
    return dp(coins, amount)
}

// 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
int dp(int[] coins, int amount) {
    // base case
    if (amount == 0) return 0;
    if (amount < 0) return -1;

    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
        // 计算子问题的结果
        int subProblem = dp(coins, amount - coin);
        // 子问题无解则跳过
        if (subProblem == -1) continue;
        // 在子问题中选择最优解，然后加一
        res = Math.min(res, subProblem + 1);
    }

    return res == Integer.MAX_VALUE ? -1 : res;
}

An AVL (Adelson-Velsky and Landis) tree is a self-balancing Binary Serch Tree (BST) where the difference between heights of left and right subtrees cannot be more than one for all nodes

A Red-Black Tree is a kind of self-balancing binary search tree whereack. A Red-Black Tree satisfies the following properties:each node has an extra bit to denote the color of the node, either red or black:
1. Every node is either red or black.
2. Every leaf (NULL) is black.
3. If a node is red, then both its children are black.
4. Every simple path from a node to a descendant leaf contains anequal number of black nodes

Which pair of the following pseudo-code snippets correctly implement the Right-Rotate operation for the AVL tree and the Insert operatioh for a Red-Black Tree, respectively? Pick one or more selections:

A. Function rightRotate(y) {
x = y.left
T2 = x.right
x.right = y
y.left = T2
update y and x heights
return x
}

B. Function rbInsert(root, key) {
    if root is null {
        return new Node(key)
    }
    if key < root.key {
        root.left = rbInsert(root.left, key)
    } else if key > root.key {
        root.right = rbInsert(root.right, key)
    } else {
        return root
    }
    fixUp(root)
    return root
}

C. Function rightRotate(y) {    
    x = y.left;
    T2 = x.right;
    x.right = y;
    y.left = T2;
    update y and x heights;
    return x;
}

D. Function rbInsert(root, key) {
    if root is null {
        return new Node(key)
    }
    if key < root.key {
        root.left = rbInsert(root.left, key)
    } else if key > root.key {
        root.right = rbInsert(root.right, key)
    } else {
        return root
    }
    fixUp(root)
    return root
}

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
        dp[0] = 0;
        dp[1] = priority.get(0);
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i-1] + priority.get(i-1), dp[i-2] + priority.get(i-1) * x);
        }
        return dp[n];
    }
    
}
public class Solution {