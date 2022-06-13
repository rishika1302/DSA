import java.util.*;
public class stackDemo{
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(10); //10
        System.out.println(stack.peek()); //10
        stack.push(20); //10 20
        stack.push(30); //10 20 30
        stack.push(40); //10 20 30 40 
        stack.push(50); //10 20 30 40 50
        stack.pop();
        System.out.println(stack.peek()); //40
        stack.pop();
        System.out.println(stack.peek()); //30
        stack.pop();
        stack.pop();
        System.out.println(stack.peek()); //10
        stack.pop();        
        if(stack.empty()){
            System.out.print("The stack is empty!");
        }else{
            System.out.print("The stack is not empty!");
        }
        System.out.println(stack.peek()); //error -> as the stack is empty now
    }
}

// import java.util.*;
// public class stackDemo{
//     public static void main(String[] args){
//         Stack<Integer> stack = new Stack<>();
//         Stack<String> sstack = new Stack<>();
//         stack.push(10);
//         stack.push(20);
//         stack.push(30);
//         System.out.print(stack.peek());
//         sstack.push("hello");
//         sstack.push("rishika");
//         System.out.print(sstack.peek());
//         sstack.pop();
//         System.out.println(sstack.peek());
//     }
// }
