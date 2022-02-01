import java.util.*;

public class lowestCommonAncestor {
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
        System.out.println("Enter two values to get their lowest common ancestor : ");
        int d1 = scn.nextInt();
        int d2 = scn.nextInt();
        System.out.println(lca(root, d1, d2));
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
    
    public static ArrayList nodeToRootPath(Node root, int data){
        if(root.data == data){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(root.data);
            return base;
        }
        for(Node child : root.children){
            ArrayList<Integer> list = nodeToRootPath(child, data);
            if(list.size()>0){
                list.add(root.data);
                return list;
            }
        }
        return new ArrayList<Integer>();
    }

    public static int lca(Node root, int d1, int d2){
        ArrayList<Integer> path1 = nodeToRootPath(root, d1);
        ArrayList<Integer> path2 = nodeToRootPath(root, d2);

        int i = path1.size()-1;
        int j = path2.size()-1;
        while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }

        i++;
        j++;

        return path1.get(i);
    }
}
