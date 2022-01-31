import java.util.*;

import jdk.nashorn.internal.ir.Node;
public class diameter {
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
      
      static int dia = 0;
      public static int calcHtretDia(Node root){
          int lh = -1;
          int slh = -1;
          for(Node child : root.children){
            int ch = calcHtretDia(child);
            if(ch>lh){
                lh = ch;
                slh = lh;
            }else if(ch>slh){
                slh = ch;
            }
          }
          int cand = lh+slh+2;
          if(cand>dia){
              dia = cand;
          }
          lh+=1;
          return lh;
      }
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        System.out.println("Diameter of tree = "+calcHtretDia(root));
        
      }    
}
