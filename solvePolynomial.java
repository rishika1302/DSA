//solve the polynomial for given values of x and n => 1.x^n + 2.x^(n-1) + 3.x^(n-2) + . . . . + n.x in O(n)

import java.util.*;
public class solvePolynomial {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(polynomial(x,n));
    }

    public static int polynomial(int x, int n){
        int a = 0;
        int pox = x;
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += (n-a)*pox;
            a++;
            pox = pox*x;
        }
        return sum;
    }
}
