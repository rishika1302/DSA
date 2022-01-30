import java.util.*;
public class nodeWithMaxSumSubtree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
      }   
      public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for(int val:arr){
            if(val!=-1){
                Node node = new Node(val);
                stack.push(node);
            }else{
                Node node = stack.pop();
                if(stack.size()>0){
                    Node parent = stack.peek();
                    parent.children.add(node);
                }else{
                    root = node;
                }
            }
        } 
        return root;
      }
      static int ms = Integer.MIN_VALUE;
      static int msn = 0;
      static int MaxSumSubtree(Node node){
          int sum = 0;
          for(Node child : node.children){
              int cmst = MaxSumSubtree(child);
              sum += cmst;
          }
          sum += node.data;
          if(sum > ms){
              msn = node.data;
              ms = sum;
          }          
          return sum;
      }
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        // write your code here
        MaxSumSubtree(root);
        System.out.println(msn+"@"+ms);
      }    
}
