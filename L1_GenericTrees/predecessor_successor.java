import java.util.*;

public class predecessor_successor {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter data = ");
        int data = scn.nextInt();
        Node root = construct(arr);
        predecessor = null;
        successor = null; 
        predecessorSuccessor(root, data);
        if(predecessor == null){
            System.out.println("Predecessor not found.");
        }else{
            System.out.println("Predecessor -> " + predecessor.data);
        }
        if(successor == null){
            System.out.println("Successor not found.");
        }else{
            System.out.println("Successor -> " + successor.data);
        }
        scn.close();
    }

    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorSuccessor(Node node, int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
            successor = node;
            state = 2;
        }
        for(Node child : node.children){
            predecessorSuccessor(child, data);
        }
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

}
