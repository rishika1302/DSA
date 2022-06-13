import java.util.*;

public class sumOfCommElements {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String input1 = scn.nextLine();
        String input2 = scn.nextLine();
        char[] i1 = input1.toCharArray();
        char[] i2 = input2.toCharArray();
        int ans = sum(i1, i2);
        System.out.println(ans);
    }
    public static int sum(char[] i1, char[] i2){
        int sum = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i=0; i<i1.length; i++){
            if(h.containsKey(i1[i])==true){
                h.put(i1[i], h.get(i1[i])+1);
            }else{
                h.put(i1[i], 1);
            }
        }
        for(int i=0; i<i2.length; i++){
            if(h.containsKey(i2[i]) == true){
                sum += i2[i];
            }
        }
        return sum;
    }
}
