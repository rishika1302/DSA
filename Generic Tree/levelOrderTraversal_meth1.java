//delimiter approach

import java.util.*;

public class levelOrderTraversal_meth1 {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(){

        }
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        levelOrder(root);
    }

    public static Node construct(int arr[]){
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

    public static void levelOrder(Node root){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        mq.add(new Node(-1));

        while(mq.size()>0){
            Node node = mq.remove();

            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    mq.add(child);
                }
            }else{
                if(mq.size()>0){
                    mq.add(new Node(-1));
                    System.out.println();
                }
            }            
        }
    }
}
