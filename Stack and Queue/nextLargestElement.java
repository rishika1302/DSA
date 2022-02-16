import java.util.*;
public class nextLargestElement {
    public static void display(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        Stack<Integer> ms = new Stack<>();
        int[] ans = new int[arr.length];
        ms.push(arr[arr.length-1]);
        ans[arr.length-1] = -1;
        for(int i=arr.length-2; i>=0; i--){
            while(ms.size()>0 && ms.peek()<arr[i]){
                ms.pop();
            }
            if(ms.size()==0){
                ans[i] = -1;
            }else{
                ans[i] = ms.peek();
            }
            ms.push(arr[i]);
        }
        System.out.println("Array of next largest integers : ");
        display(ans);
    }
}
