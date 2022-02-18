import java.util.*;
import java.io.*;
public class infixEvaluation {
    public static int precedence(char ch){
        if(ch == '+'){
            return 1;
        }else if(ch == '-'){
            return 1;
        }else if(ch == '*'){
            return 2;
        }else{
            return 2;
        }
    }

    public static int operation(int v1, int v2, char operator){
        if(operator == '+'){
            return v1+v2;
        }else if(operator == '-'){
            return v1-v2;
        }else if(operator == '*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }else if(Character.isDigit(ch)){
                int digit = ch-'0';
                operands.push(digit);
            }else if(ch == ')'){
                while(operators.peek()!='('){
                    Character operator = operators.pop();
                    int val1 = operands.pop();
                    int val2 = operands.pop();
                    int ans = operation(val2, val1, operator);
                    operands.push(ans);
                }
                operators.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operators.size()>0 && operators.peek()!='(' && precedence(ch)<=precedence(operators.peek())){
                    Character operator = operators.pop();
                    int val1 = operands.pop();
                    int val2 = operands.pop();
                    int ans = operation(val2, val1, operator);
                    operands.push(ans);
                }
                operators.push(ch);
            }
        }
        while(operators.size()!=0){
            char operator = operators.pop();
            int val1 = operands.pop();
            int val2 = operands.pop();
            int ans = operation(val2, val1, operator);
            operands.push(ans);
        }
        System.out.println(operands.peek());
    }
}
