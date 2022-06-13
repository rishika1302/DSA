import java.util.*;
public class findKLargestElements {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter k : ");
        int k = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            if(i<k){
                pq.add(arr[i]);
            }else{
                if(arr[i]>pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while(pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }
        scn.close();
    }
}
