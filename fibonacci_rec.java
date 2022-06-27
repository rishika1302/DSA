import java.util.*;
public class fibonacci_rec {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.print(fib(n));
    }

    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int fibn;
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        fibn = fibnm1 + fibnm2;
        return fibn;
    }
}
