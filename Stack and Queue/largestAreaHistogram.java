import java.util.*;
public class largestAreaHistogram {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int[] rightBound = new int[n];
        Stack<Integer> rs = new Stack<>();
        rightBound[n-1] = n;
        rs.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(rs.size()>0 && arr[i]<arr[rs.peek()]){
                rs.pop();
            }
            if(rs.size()==0){
                rightBound[i] = n;
            }else{
                rightBound[i] = rs.peek();
            }
            rs.push(i);
        }

        int[] leftBound = new int[n];
        Stack<Integer> ls = new Stack<>();
        leftBound[0] = -1;
        ls.push(0);
        for(int i=1; i<n; i++){
            while(ls.size()>0 && arr[i]<arr[ls.peek()]){
                ls.pop();
            }
            if(ls.size()==0){
                leftBound[i] = -1;
            }else{
                leftBound[i] = ls.peek();
            }
            ls.push(i);
        }        
        
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = rightBound[i] - leftBound[i] - 1;
            int area = arr[i]*width;
            if(area > maxArea){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
}
