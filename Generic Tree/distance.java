import java.util.*;

public class distance {
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
        int d1 = scn.nextInt();
        int d2 = scn.nextInt();
        System.out.println(Distance(root, d1, d2));
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

    public static int Distance(Node root, int d1, int d2){
        ArrayList<Integer> path1 = nodeToRoot(root, d1);
        ArrayList<Integer> path2 = nodeToRoot(root, d2);

        int i = path1.size()-1;
        int j = path2.size()-1;
        while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }

        i++;
        j++;
        return i+j;
    }
}
