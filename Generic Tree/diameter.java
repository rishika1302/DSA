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
      static int calcHretDia(Node node){
          int dch = -1;
          int sdch = -1;
          for(Node child : node.children){
              int ch = calcHretDia(child);
              if(ch>dch){
                  sdch = dch;
                  dch = ch;
              }else if(ch>sdch){
                  sdch = ch;
              }
          }
          int check = dch+sdch+2;
          if(check>dia){
              dia = check;
          }
          dch += 1;
          return dch;
      }
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        Node root = construct(arr);
        calcHretDia(root);
        System.out.println("Diameter of tree = "+dia);
        
      }    
}
