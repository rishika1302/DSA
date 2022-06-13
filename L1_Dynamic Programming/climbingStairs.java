//climbing stairs -> number of ways to go from 0th step to nth step of a staircase given that you can take 1 step and 2 steps only.

import java.util.*;
public class climbingStairs {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = climbStairs(n); //memoized
        int anst = climbStairsTab(n); //tabulation
        System.out.println(ans+" "+anst);
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
    public static int climbStairsTab(int n){    //tabulation
        int[] dp = new int[n+1];
        for(int N=0; N<=n; N++){
            if(N<=1){
                dp[N] = 1;
                continue;
            }
            dp[N] = dp[N-1] + dp[N-2];
        }
        return dp[n];
    }
}
