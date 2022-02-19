import java.util.*;
import java.io.*;

public class infixConversions {
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
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch == '('){
                optors.push(ch);
            }else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>=0 && ch<=9)){
                pre.push(ch+"");
                post.push(ch+"");
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(optors.size()>0 && optors.peek()!='(' && precedence(ch)<=precedence(optors.peek())){
                    char operator = optors.pop();
                    String preVal1 = pre.pop();
                    String preVal2 = pre.pop();
                    String preAns = operator + preVal2 + preVal1;
                    pre.push(preAns);
                    String postVal1 = post.pop();
                    String postVal2 = post.pop();
                    String postAns = postVal2 + postVal1 + operator;
                    post.push(postAns);
                }
                optors.push(ch);
            }else if(ch == ')'){
                while(optors.peek()!='('){
                    char operator = optors.pop();
                    String preVal1 = pre.pop();
                    String preVal2 = pre.pop();
                    String preAns = operator + preVal2 + preVal1;
                    pre.push(preAns);
                    String postVal1 = post.pop();
                    String postVal2 = post.pop();
                    String postAns = postVal2 + postVal1 + operator;
                    post.push(postAns);
                }
                optors.pop();
            }
        }
        while(optors.size()>0){
            char operator = optors.pop();
            String preVal1 = pre.pop();
            String preVal2 = pre.pop();
            String preAns = operator + preVal2 + preVal1;
            pre.push(preAns);
            String postVal1 = post.pop();
            String postVal2 = post.pop();
            String postAns = postVal2 + postVal1 + operator;
            post.push(postAns);
        }
        System.out.println("Pre = " + pre.peek());
        System.out.println("Post = " + post.peek());
    }
}
