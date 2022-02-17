import java.io.*;
import java.util.*;

public class slidingWindowMaximum{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int[] nge = new int[arr.length];
    Stack<Integer> ms = new Stack<>();
    nge[arr.length-1] = arr.length;
    ms.push(arr.length-1);
    for(int i=arr.length-2; i>=0; i--){
       while(ms.size()>0 && arr[i]>=arr[ms.peek()]){
          ms.pop();
       }
       if(ms.size()==0){
          nge[i] = arr.length;
       }else{
          nge[i] = ms.peek();
       }
       ms.push(i);
    }
    int j = 0;
    for(int i=0; i<=arr.length-k; i++){
       if(j < i){
          j = i;
       }
       while(nge[j] < i+k){
          j = nge[j];
       }
       System.out.println(arr[j]);
    }
 }
}