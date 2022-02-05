import java.util.*;
public class sortKArray {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the partly(k) sorted array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter k : ");
        int k = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<=k; i++){
            pq.add(arr[i]);
        }
        for(int i=k+1; i<arr.length; i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
        scn.close();
    }
}
