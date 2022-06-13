import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
public class balancedBrackets {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Character> ms = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                ms.push(ch);
            }else if(ch == ')'){
                if(ms.size()==0){
                    System.out.println(false);
                    return;
                }else if(ms.peek()!='('){
                    System.out.println(false);
                    return;
                }else{
                    ms.pop();
                }
            }else if(ch == '}'){
                if(ms.size()==0){
                    System.out.println(false);
                    return;
                }else if(ms.peek()!='{'){
                    System.out.println(false);
                    return;
                }else{
                    ms.pop();
                }
            }else if(ch == ']'){
                if(ms.size()==0){
                    System.out.println(false);
                    return;
                }else if(ms.peek()!='['){
                    System.out.println(false);
                    return;
                }else{
                    ms.pop();
                }
            }
        }
        if(ms.size()>0){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }
}
