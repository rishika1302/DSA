import java.util.*;

public class isTreeSymmetric{
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
        // int[] arr1 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1}; //ans -> false
        int[] arr2 = {10, 20, 50, 90, -1, 100, -1, -1, -1, 30, 60, 110, -1, -1, 70, 120, -1, -1, -1, 40, 80, 130, -1, 140, -1, -1, -1, -1}; //ans -> true
        Node root1 = construct(arr2);
        boolean ans = isSymmetric(root1);
        System.out.println(ans);
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
    
    public static boolean areMirror(Node root1, Node root2){
        if(root1.children.size() != root2.children.size()){
            return false;
        }
        for(int i=0; i<root1.children.size(); i++){
            Node c1 = root1.children.get(i);
            Node c2 = root2.children.get(root2.children.size()-1-i);
            if(areMirror(c1, c2) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(Node node){
        return areMirror(node, node);
    }
}

