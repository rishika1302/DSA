import java.util.*;
public class fibonacci {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        int fibOf_n = fib_mem(n, dp);
        System.out.println(fibOf_n);
        scn.close();
    }
    public static int fib(int n){
        if(n<=1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1+fnm2;
        return fn;
    }
    public static int fib_mem(int n, int[] dp){
        if(n<=1) return dp[n] = n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fib_mem(n-1, dp)+fib_mem(n-2, dp);
    }
}

