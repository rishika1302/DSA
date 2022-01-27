import java.io.*;
import java.util.*;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        System.out.println("Number of elements in the array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter "+n+" elements in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        //first loop(1st iteration on all elements) -> for all elements of array, make the value true
        for(int val : arr){
            map.put(val, true);
        }

        //second loop -> if we can find element-1 in the map, this means element has a predecessor and can't be starting point of a sequence, hence, make these keys false
        for(int val : arr){
            if(map.containsKey(val-1) == true){
                map.put(val,false);
            }
        }

        int maxStartingPoint = 0; //initialize starting point of largest sequence to be 0
        int maxStartingLength = 0; //initialize length of largest sequence to be 0

        //third loop -> work only on those keys which have value true as only they have the potential to be starting points of sequences with consecutive numbers
        for(int val : arr){
            if(map.get(val) == true){ //check for true values
                int tempStartingPoint = val; //intialize the key/value of array to be temp starting point of sequence
                int tempStartingLength = 1; //intilialize the length of sequence to be 1
                while(map.containsKey(tempStartingPoint+tempStartingLength)==true){ //increasing length of sequence to the point we are able to find consecutive successors of the tempSP(i.e. val)
                    tempStartingLength++;
                }
                if(tempStartingLength > maxStartingLength){ //finding the maximum starting length to get the largest consecutive sequence
                    maxStartingLength = tempStartingLength;
                    maxStartingPoint = tempStartingPoint;
                }
            }
        }

        System.out.print("The longest consecutive sequence in array arr is : ");
        for(int i=0; i<maxStartingLength; i++){
            //printing the largest sequence by adding i in maxSP upto i=length of largest sequence
            System.out.print(maxStartingPoint + i +", ");
        }
    }
}
