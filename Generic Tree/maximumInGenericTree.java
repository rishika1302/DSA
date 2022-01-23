import java.util.*;
public class maximumInGenericTree {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        Node root = new Node(300);
        Node twenty = new Node(20);
        root.children.add(twenty);
        Node thirty = new Node(30);
        root.children.add(thirty);
        Node forty = new Node(40);
        root.children.add(forty);
        Node fifty = new Node(50);
        twenty.children.add(fifty);
        Node sixty = new Node(60);
        twenty.children.add(sixty);
        Node seventy = new Node(70);
        thirty.children.add(seventy);
        Node eighty = new Node(80);
        thirty.children.add(eighty);
        Node ninety = new Node(90);
        thirty.children.add(ninety);
        Node hundred = new Node(100);
        forty.children.add(hundred);
        Node hten = new Node(110);
        eighty.children.add(hten);
        Node htwenty = new Node(120);
        eighty.children.add(htwenty);

        System.out.print(max(root));
    }

    public static int max(Node root){
        int m = Integer.MIN_VALUE;
        for(Node child : root.children){
            int ch_max = max(child);
            m = Math.max(ch_max, m);
        }
        m = Math.max(root.data, m);
        return m;
    }
}
