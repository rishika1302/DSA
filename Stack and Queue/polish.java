import java.util.*;
public class polish {
    public static int operation(int val1, int val2, String optor){
        if(optor.equals("+")){
            return val2+val1;
        }else if(optor.equals("-")){
            return val2-val1;
        }else if(optor.equals("*")){
            return val2*val1;
        }else{
            return val2/val1;
        }
    }
    public static void main(String[] args){
        String[] tokens = {"4", "13", "5", "/", "+"};
        Stack<Integer> value = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int v1 = value.pop();
                int v2 = value.pop();
                int ans = operation(v1, v2, s);
                value.push(ans);
            }else{
                int dig = Integer.parseInt(s);
                value.push(dig);
            }
        }
        System.out.println(value.peek());
    }
}
