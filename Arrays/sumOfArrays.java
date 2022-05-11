package Arrays;
import java.util.*;
public class sumOfArrays {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Size of 1st array : ");
        int n1 = scn.nextInt();
        System.out.println("Elements of 1st array : ");
        int[] a1 = new int[n1];
        for(int i=0; i<n1; i++){
            a1[i] = scn.nextInt();
        }
        System.out.println("Size of 2nd array : ");
        int n2 = scn.nextInt();
        System.out.println("Elements of 2nd array : ");
        int[] a2 = new int[n2];
        for(int i=0; i<n2; i++){
            a2[i] = scn.nextInt();
        }
        int sumlen = n2>n1 ? n2:n1; //length of sum array is greater of the length of the two arrays
        int[] sum = new int[sumlen];
        int i = a1.length-1;
        int j = a2.length-1;
        int k = sum.length-1;
        int carry = 0;
        while(k>=0){
            int data = carry;
            if(i>=0){
                data = data+a1[i];
            }
            if(j>=0){
                data = data+a2[j];
            }
            carry = data/10;
            data = data%10;
            sum[k] = data;
            i--;
            j--;
            k--;
    }
    if(carry>0){
        System.out.println(carry);
    }
    System.out.println("Sum of two arrays : ");
    for(int p=0; p<sumlen; p++){
        System.out.println(sum[p]);
    }
    scn.close();
}
}
