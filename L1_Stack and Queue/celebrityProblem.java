import java.io.*;
import java.util.*;

public class celebrityProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr){
        Stack<Integer> ms = new Stack<>();
        for(int i=0; i<arr.length; i++){
            ms.push(i); //push all indexes of array into stack
        }
        while(ms.size()>=2){  //pop 2 elements from stack until there are 2 or more left in it
            int i = ms.pop();
            int j = ms.pop();
            if(arr[i][j] == 1){ //if i knows j -> i can't be a celeb
                ms.push(j); //push the potential celeb in, since only 1 can be celeb, the one with potential is pushed not the other one.
            }else{ //if j knows i -> j can't be a celeb
                ms.push(i);
            }
        }
        int potential = ms.pop(); //after all pops, the last one left is the potential celeb
        for(int i=0; i<arr.length; i++){
            if(i != potential){ //checking if i knows itself -> invalid
                if(arr[i][potential] == 0 || arr[potential][i] == 1){
                    //if i doesnot know potential, potential can't be a celeb OR if potential knows i then it can't be a celeb
                    System.out.println("none"); //in both the above mentioned cases, potential can't be a celeb -> no celeb
                    return; //there can be only 1 celeb, if potential is not the celeb, return.
                }
            }
        }
        System.out.println(potential); //after all above checks, if still potential survives then its a celebrity
    }    
}
