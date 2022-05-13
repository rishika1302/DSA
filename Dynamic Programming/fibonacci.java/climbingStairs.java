//climbing stairs -> number of ways to go from 0th step to nth step of a staircase given that you can take 1 step and 2 steps only.

import java.util.*;
public class climbingStairs {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = climbStairs(n);
        System.out.println(ans);
    }
    public static int climbStairs(int n){   //memoization
        int[] dp = new int[n+1];
        if(n==0){               //base case
            return dp[n] = 1;
        }
        if(n==1){               //edge case
            return dp[n] = 1;
        }
        return dp[n] = climbStairs(n-1) + climbStairs(n-2);
    }
}
