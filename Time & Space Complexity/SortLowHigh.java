import java.io.*;
import java.util.*;

public class SortLowHigh {

  public static void sortlowhigh(int[] arr, int lo, int hi){
    int i=0;
    int j=0;
    int k=arr.length-1;
    while(i<=k){
        if(arr[i]<=lo){
            swap(arr,i,j);
            i++;
            j++;
        } else if(arr[i]>lo && arr[i]<hi){
            i++;
        }else if(arr[i]>=hi){
            swap(arr,i,k);
            k--;
        }
    }
    }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int low = scn.nextInt();
    int high = scn.nextInt();
    sortlowhigh(arr,low,high);
    print(arr);
  }

}