import java.util.*;

public class largestNumber {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int j=1; j<=t; j++){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = scn.nextInt();
            }
            int max = arr[0];
            int maxidx = 0;
            for(int i=0; i<n; i++){
        if(arr[i]>=max){
          max = arr[i];
          maxidx = i;
        }
      }
      int temp = arr[maxidx];
      arr[maxidx] = arr[0];
      arr[0] = temp;
      for(int i=0; i<n; i++){
        System.out.print(arr[i]+" ");
      }System.out.println();
        }
        scn.close();
  }

}