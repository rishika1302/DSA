import java.util.*;
public class firstNlastVowel {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextLine();
        }
        String ans = findStringVowelFirstAndLast(n, arr);
        System.out.println(ans);
    }
    public static String findStringVowelFirstAndLast(int input1, String[] input2){
        String ans = "";
        for(String s: input2){
            if(isVowel(s.charAt(1))==true && isVowel(s.charAt(s.length()))==true){
                ans += s.toLowerCase();
            }
        }
        if(ans ==""){
            ans = "no matches found";
        }
        return ans;
    }
    public static boolean isVowel(char ch){
        if(ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u' || ch == 'A'||ch == 'E'||ch == 'I'||ch == 'O'||ch == 'U'){
            return true;
        }else{
            return false;
        }
    }

}
