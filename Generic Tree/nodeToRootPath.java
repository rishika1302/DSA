import java.util.*;

public class nodeToRootPath {
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
        System.out.println("Enter the data to get its node to root path : ");
        int data = scn.nextInt();
        ArrayList<Integer> path = nodeToRoot(root, data);
        System.out.println(path);
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
    
    public static ArrayList<Integer> nodeToRoot(Node root, int data){
        if(root.data == data){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(root.data);
            return base;
        }
        for(Node child : root.children){
            ArrayList<Integer> pathToChild = nodeToRoot(child, data);
            if(pathToChild.size()>0){
                pathToChild.add(root.data);
                return pathToChild;
            }
        }
        return new ArrayList<>();
    }
}
