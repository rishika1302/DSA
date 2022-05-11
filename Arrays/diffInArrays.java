package Arrays;

import java.util.*;
public class diffInArrays {
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
        scn.close();
        int[] diff = new int[n2>n1 ? n2:n1];
        int i = a1.length-1;
        int j = a2.length-1;
        int k = diff.length-1;
        int carry = 0;
        while(k>=0){
            
        }
    }
}
