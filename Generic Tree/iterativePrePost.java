import java.util.*;
public class iterativePrePost {
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
      static class Pair{
          Node node;
          int state;
          Pair(Node node, int state){
              this.node = node;
              this.state = state;
          }
      }
      public static void prePost(Node node){
          Stack<Pair> s = new Stack<>();
          String pre = "";
          String post = "";
          Pair p = new Pair(node, -1);
          s.push(p);
          while(s.size()>0){
              Pair top = s.peek();
              if(top.state == -1){
                pre += top.node.data+" ";
                top.state++;
              }else if(top.state>=0 && top.state<node.children.size()){
                Pair childpair = new Pair(top.node.children.get(top.state), -1);
                s.push(childpair); 
                top.state++;
              }else{
                post += top.node.data+" ";
                s.pop();
              }
          }
          System.out.println(pre);
          System.out.println(post);
      }
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        Node root = construct(arr);
        prePost(root);
        
      }    
}
