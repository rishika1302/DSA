import java.util.*;

public class multisolver {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }

    static int size;
    static int min;
    static int max;
    static int height;
    public static void main(String[] args){
        int[] arr = {10, 20, 50, 90, -1, 100, -1, -1, -1, 30, 60, 110, -1, -1, 70, 120, -1, -1, -1, 40, 80, 130, -1, 140, -1, -1, -1, -1};
        Node root = construct(arr); 
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
        Multisolver(root, 0);
        System.out.println("size = " + size);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("height = " + height);
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

    public static void display(Node node){
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static void Multisolver(Node root, int depth){
        size++;
        min = Math.min(min, root.data);
        max = Math.max(max, root.data);
        height = Math.max(height, depth);
        for(Node child : root.children){
            Multisolver(child, depth+1);
        }
    }
}
