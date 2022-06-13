import java.util.*;

public class areTwoTreesSimilarInShape{
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
        int[] arr1 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root1 = construct(arr1);
        int[] arr2 = {1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, 10, -1, -1, -1};
        Node root2 = construct(arr2);
        boolean ans = areSimilar(root1, root2);
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
    
    public static boolean areSimilar(Node root1, Node root2){
        if(root1.children.size() != root2.children.size()){ //L1
            return false; //L2
        }
        for(int i=0; i<root1.children.size(); i++){ //L3
            Node c1 = root1.children.get(i); //L4
            Node c2 = root2.children.get(i); //L5
            if(areSimilar(c1, c2) == false){ //L6
                return false; //L7
            }
        }
        return true; //L8
    }
}

