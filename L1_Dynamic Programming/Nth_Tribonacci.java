import java.util.*;
public class Nth_Tribonacci {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = tribonacciMem(n);
        System.out.println(ans);
    }

    public static int tribonacciMem(int n){
        int[] dp = new int[n+1];
        for(int N=0; N<=n; N++){
            if(N==0){
                dp[N] = N;
                continue;
            }else if(N==1 || N==2){
                dp[N] = 1;
                continue;
            }
            dp[N] = dp[N-1] + dp[N-2] + dp[N-3]; 
        }
        return dp[n];
    }
}
