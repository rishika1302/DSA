import java.util.*;
public class asciiSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int ans = findASCIISum(s);
        System.out.println(ans);
    }
    public static int findASCIISum(String input1){
        int sum = 0;
        if(input1.contains(" ") || input1.matches("[a-zA-Z]+") == false){
            sum = 1;
        }else{
            int a1 = (int) input1.charAt(0);
            int a2 = (int) input1.charAt(input1.length() - 1);
            sum = a1+a2;
        }
        return sum;
    }
}
