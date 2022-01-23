// package Level1.RecursionWithArrayLists;
import java.util.*;
public class gss {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ans = gss(str);
        System.out.println(ans);
    }

    public static ArrayList<String> gss(String str){
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);//x
        String ros = str.substring(1);//yz
        ArrayList<String> rres = gss(ros);//--,-z,y-,yz
        ArrayList<String> mres = new ArrayList<>();
        for(String val:rres){
            String mval = val;
            mres.add("-"+mval);
        }
        for(String val:rres){
            String mval = val;
            mres.add(ch+mval);
        }
        return mres;
    }
}
