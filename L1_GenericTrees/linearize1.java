//O(n^2) - inefficient

import java.util.*;
public class linearize1 {
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
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        linearize(root);
        levelOrder(root);
    }

    public static Node construct(int[] arr){
        Stack<Node> ms = new Stack<>();
        Node root = null;

        for(int val : arr){
            if(val!=-1){
                Node node = new Node(val);
                ms.push(node);
            }else{
                Node node = ms.pop();
                if(ms.size()>0){     
                    Node parent = ms.peek();
                    parent.children.add(node);
                }else{
                    root = node;
                }
            }
        }
        return root;
    }

    //levelOrder zig-zag -> when the tree has been linearized it wont matter if the tree is printed level order linewise or zigzag
    public static void levelOrder(Node root){
        int level = 1;
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(root);
        while(ms.size()>0){
            Node node = ms.pop();
            System.out.print(node.data + " ");
            if(level%2==1){
                for(int i=0; i<node.children.size(); i++){
                    cs.add(node.children.get(i));
                }
            }else{
                for(int i=node.children.size()-1; i>=0; i--){
                    cs.add(node.children.get(i));
                }
            }
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<Node>();
                level++;
                System.out.println();
            }
        }
        
    }

    private static Node getTail(Node root){
        while(root.children.size() == 1){
            root = root.children.get(root.children.size()-1);
        }
        return root;
    }
    public static void linearize(Node root){
        for(Node child : root.children){
            linearize(child);
        }
        while(root.children.size()>1){
            Node lc = root.children.remove(root.children.size()-1);
            Node slc = root.children.get(root.children.size()-1);
            Node slt = getTail(slc);
            slt.children.add(lc);
        }
    }
}
