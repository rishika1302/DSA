import java.util.*;
public class prefixEvaluationConversion {
    public static int operation(int val1, int val2, char optor){
        if(optor == '+'){
            return val1+val2;
        }else if(optor == '-'){
            return val1-val2;
        }else if(optor == '*'){
            return val1*val2;
        }else{
            return val1/val2;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //value evaluation
                int v1 = value.pop();
                int v2 = value.pop();
                int ans = operation(v1, v2, ch);
                value.push(ans);

                //infix notation
                String iv1 = infix.pop();
                String iv2 = infix.pop();
                String iv = "(" + iv1 + ch + iv2 + ")";
                infix.push(iv);

                //postfix notation
                String pv1 = postfix.pop();
                String pv2 = postfix.pop();
                String pv = pv1 + pv2 + ch;
                postfix.push(pv);
            }else{
                value.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            }
        }
        System.out.println("Value = " + value.peek());
        System.out.println("Infix = " + infix.peek());
        System.out.println("Postfix = " + postfix.peek());
    }
}
