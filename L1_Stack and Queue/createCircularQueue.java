import java.util.*;

public class createCircularQueue {
    public static void main(String[] args){
        
    }   
    class MyCircularQueue {
        int[] data;
        int front;
        int size;
    
    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == data.length){
            return false;
        }else{
            data[(front+size)%data.length] = value;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }else{
            front = (front+1)%data.length;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if(size==0){
            return 0;
        }else{
            return data[front];
        }
            
    }
    
    public int Rear() {
        int rearIdx = ((front+size)-1)%data.length;
        return data[rearIdx];
    }
    
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull() {
        if(size == data.length){
            return true;
        }else{
            return false;
        }
    }
}
}
