import java.util.*;
public class stockSpan {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] stock = new int[n];
        for(int i=0; i<n; i++){
            stock[i] = scn.nextInt();
        }
        display(StockSpan(stock));
    }
    public static void display(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ ", ");
        }
    }
    public static int[] StockSpan(int[] arr){
        int[] span = new int[arr.length];
        Stack<Integer> ms = new Stack<>();
        span[0] = 1;
        ms.push(0);
        for(int i=1; i<arr.length; i++){
            while(ms.size()>0 && arr[i]>arr[ms.peek()]){
                ms.pop();
            }
            if(ms.size()==0){
                span[i] = i+1;
            }else{
                span[i] = i-ms.peek();
            }
            ms.push(i);
        }
        return span;
    }
    
}
