import java.util.*;

public class ceilFloor {
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
        System.out.println("Enter data to find its ceil and floor = ");
        int data = scn.nextInt();
        Node root = construct(arr);
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE; 
        ceil_Floor(root, data);
        System.out.println("Ceil - " + ceil);
        System.out.println("Floor - " + floor);
        scn.close();
    }

    static int ceil;
    static int floor;
    public static void ceil_Floor(Node node, int data){
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }
        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }
        for(Node child : node.children){
            ceil_Floor(child, data);
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
