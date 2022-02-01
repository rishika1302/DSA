import java.util.*;

public class find {
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
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the data to be found in generic tree : ");
        int data = scn.nextInt();
        System.out.println(Find(root, data));
        scn.close();
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

    public static boolean Find(Node root, int data){
        if(root.data == data){
            return true;
        }
        for(Node child : root.children){
            boolean check = Find(child, data);
            if(check){
                return true;
            }
        }
        return false;
    }
    
    
}
