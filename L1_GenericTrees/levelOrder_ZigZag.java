import java.util.*;

public class levelOrder_ZigZag {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        levelorderZZ(root);
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

    public static void levelorderZZ(Node root){
        Stack<Node> ms = new Stack<Node>();
        Stack<Node> cs = new Stack<Node>();
        int level = 1;
        ms.push(root);
        while(ms.size()>0){
            Node node = ms.pop();
            System.out.print(node.data + " ");
            if(level%2 == 1){
                for(int i=0; i<node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }else{
                for(int i=node.children.size()-1; i>=0; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
}
