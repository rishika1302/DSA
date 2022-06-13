import java.util.*;
public class queueDemo {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue); //10, 20, 30
        queue.add(40);
        queue.add(50);
        System.out.println(queue); //10, 20, 30, 40, 50
        queue.remove(); //10 removed
        System.out.println(queue); //20, 30, 40, 50
        queue.remove(); //20 removed
        queue.remove(); //30 removed
        queue.remove(); //40 removed
        System.out.println(queue); //50
        queue.remove(); //50 removed
        System.out.println(queue); //queue is empty
    }
}

// import java.util.*;
// public class queueDemo{
//     public static void main(String[] args){
//         Queue<Integer> queue = new ArrayDeque<>();
//         queue.add(10);
//         queue.add(20);
//         queue.add(30);
//         System.out.println(queue.size());
//         System.out.println(queue.peek());
//         queue.remove();
//         System.out.println(queue.peek());
//         System.out.print(queue.size());
//     }
// }
