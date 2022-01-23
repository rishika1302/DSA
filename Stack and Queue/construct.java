import java.util.*;

import javafx.scene.Node;
public class construct {
    public static Node construct(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(arr[i]!=-1){
            
            stack.push(arr[i]);

        }
    }
    public static void main(String[] args){
        int arr[] = {10, 20, 50, -1, 60, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
    }
    Node root = construct(arr);
}
