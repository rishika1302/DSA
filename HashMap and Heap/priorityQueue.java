import java.util.*;
public class priorityQueue {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //default = smaller value is given high priority
        int[] ranklist = {33, 80, 1, 99, 12, 3, 45, 4};
        for(int val : ranklist){
            pq.add(val); //add values one by one from ranklist to the priority queue
        }
        while(pq.size()>0){
            System.out.println(pq.peek()); //print the element with highest priority as shown from .peek()
            pq.remove(); //remove the element with highest priority so that the next one can come to top of the pq
        }
    }
}
