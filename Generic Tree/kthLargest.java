import java.util.*;

public class kthLargest {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter k = ");
        int k = scn.nextInt();
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        Node root = construct(arr);
        int lar = kthLargestElement(root, k);
        System.out.println(lar);
        scn.close();
    }
    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> ms = new Stack<Node>();
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

    static int ceil;
    static int floor;
    public static void ceilFloor(Node root, int data){
        if(root.data > data){
            if(root.data < ceil){
                ceil = root.data;
            }
        }else if(root.data < data){
            if(root.data > floor){
                floor = root.data;
            }
        }
        for(Node child : root.children){
            ceilFloor(child, data);
        }
    }

    public static int kthLargestElement(Node root, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            ceilFloor(root, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }
}
