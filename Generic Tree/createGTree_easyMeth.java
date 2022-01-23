import java.util.*;
public class createGTree_easyMeth {
    public static class Node{ //Node class
        int data; //data member -> data
        ArrayList<Node> children = new ArrayList<Node>(); //children -> which is an arraylist
        //constructor Node
        Node(int data){
            this.data = data; //initializes the object 
        }
    }
    public static void main(String[] args){
        Node root = new Node(100);
        //new Node() -> makes a node w/ data and children(AL)
        //new Node(10)<- this 10 is assigned with the help of constructor node 
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
    }
}
