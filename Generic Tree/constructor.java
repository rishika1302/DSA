import java.util.*;
public class constructor {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = constructor_euler(arr);
        levelorderLineWise(root);
    }
    public static void levelorderLineWise(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        Queue<Node> cqueue = new ArrayDeque<Node>();
        queue.add(root);
        while(queue.size()>0){
            Node temp = queue.remove();
            System.out.print(temp.data+" ");

            for(Node child : temp.children){
                cqueue.add(child);
            }
            if(queue.size()==0){
                queue = cqueue;
                cqueue = new ArrayDeque<>();
                System.out.println(".");
            }
        }
    }
    
    public static Node constructor_euler(int[] arr){
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

}
