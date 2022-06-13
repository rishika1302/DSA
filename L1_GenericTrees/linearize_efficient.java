import java.util.*;

public class linearize_efficient {
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
        linearizeEfficient(root);
        levelOrderLineWise(root);
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

    public static void levelOrderLineWise(Node root){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        mq.add(new Node(-1));

        while(mq.size()>0){
            Node node = mq.remove();

            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    mq.add(child);
                }
            }else{
                if(mq.size()>0){
                    mq.add(new Node(-1));
                    System.out.println();
                }
            }            
        } 
    }

    public static Node linearizeEfficient(Node root){
        if(root.children.size() == 0){
            return root;
        }
        Node lct = linearizeEfficient(root.children.get(root.children.size()-1));
        while(root.children.size() > 1){
            Node lc = root.children.remove(root.children.size()-1);
            Node slc = root.children.get(root.children.size()-1);
            Node slt = linearizeEfficient(slc);
            slt.children.add(lc);
        }
        return lct;
    }
}
