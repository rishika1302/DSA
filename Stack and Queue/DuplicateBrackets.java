import java.util.*;
public class DuplicateBrackets {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        scn.close();
        Stack<Character> ms = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch == ')'){
                if(ms.peek() == '('){
                    System.out.println(true);
                    return;
                }else{
                    while(ms.size()>0 && ms.peek()!='('){
                        ms.pop();
                    }
                }
                ms.pop();
            }else{
                ms.push(ch);
            }
        }
        System.out.println(false);
    }
}
