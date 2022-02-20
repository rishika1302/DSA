//convert postfix into prefix and infix, also calc the value of the expression
import java.util.*;
public class postfixEvaluationConversion {
    public static int operation(int val1, int val2, char optor){
        if(optor == '+'){
            return val2+val1;
        }else if(optor == '-'){
            return val2-val1;
        }else if(optor == '*'){
            return val2*val1;
        }else{
            return val2/val1;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> value = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //value
                int v1 = value.pop();
                int v2 = value.pop();
                int ans = operation(v1, v2, ch);
                value.push(ans);

                //infix notation
                String iv1 = infix.pop();
                String iv2 = infix.pop();
                String inf = "(" + iv2 + ch + iv1 + ")";
                infix.push(inf);

                //prefix notation
                String pv1 = prefix.pop();
                String pv2 = prefix.pop();
                String pnf = ch + pv2 + pv1;
                prefix.push(pnf);
            }else{
                infix.push(ch+"");
                prefix.push(ch+"");
                value.push(ch-'0');
            }
        }
        System.out.println("Value = "+value.peek());
        System.out.println("Infix = "+infix.peek());
        System.out.println("Prefix = "+prefix.peek());
    }
}
