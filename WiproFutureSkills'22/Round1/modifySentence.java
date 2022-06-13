import java.util.*;
public class modifySentence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = changeSentence(str);
        System.out.println(ans);
    }
    public static String changeSentence(String s){
        String ans = "";
        String a[] = s.split(" ");
        for(int j=0; j<a.length; j++){
            String c = a[j];
            String incr = new String();
            for(int i=0; i<c.length(); i++){
                char init = c.charAt(i);
                char upd = (char)(c.charAt(i) + c.length());
                if(Character.isLowerCase(init)==true  && upd > 'z'){
                    upd = 'z';
                }else if(Character.isUpperCase(init) == true && upd > 'Z'){
                    upd = 'Z';
                }
                incr += upd;
            }
            if(j<a.length-1){
                ans += incr + " ";
            }else{
                ans += incr;
            }
        }

        return ans;
    }
}
