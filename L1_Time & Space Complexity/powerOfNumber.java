import java.util.*;
public class powerOfNumber {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        //way 1 -> normal loop until n bcs x^n=x*x*x*...n times TC = O(n)
        System.out.println(pow1(x, n));

        //way 2 -> recursive bcs TC = O(log n)
        // x^n = x^(n/2)*x^(n/2) when n is even
        // x^n = x^(n/2)*x^(n/2)*x when n is odd
        System.out.println(pow2(x, n));
    }

    public static int pow1(int x, int n){
        int ans = 1;
        for(int i=0; i<n; i++){
            ans = ans*x;
        }
        return ans;
    }
    
    public static int pow2(int x, int n){
        if(n==0){
            return 1;
        }
        int xpnb2 = pow2(x, n/2);
        int xpn = xpnb2*xpnb2;
        if(n%2 == 0){
            return xpn;
        }else{
            return xpn*x;
        }
    }

}
