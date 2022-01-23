import java.util.*;

public class levelOrderTraversal_meth3 {
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
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        levelOrder(root);
    }

    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for(int val:arr){
            if(val!=-1){
                Node node = new Node(val);
                stack.push(node);
            }else{
                Node node = stack.pop();
                if(stack.size()>0){
                    Node parent = stack.peek();
                    parent.children.add(node);
                }else{
                    root = node;
                }
            }
        }
        return root;
    }
    
    private static class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void levelOrder(Node root){
        int level = 1;
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(root, 1));

        while(mq.size()>0){
            Pair p = mq.remove();
            if(p.level > level){
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for(Node child : p.node.children){
                Pair child_pair = new Pair(child, p.level+1);
                mq.add(child_pair);
            }
        }
    }  
}
