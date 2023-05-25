package CompanyQuestions.HuaweiJishi.表达式求值.HJ54表达式求值_HARD;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int index=0, flag = 1;
        while(index<s.length()){
            if(s.charAt(index)=='-' && (index==0 || s.charAt(index-1)=='(' || s.charAt(index-1)=='+'
                    || s.charAt(index-1)=='-' || s.charAt(index-1)=='*' || s.charAt(index-1)=='/')){
                flag = -1;
                index++;
            }
            if(s.charAt(index)-'0'>=0 && s.charAt(index)-'9'<=0){
                int i = index+1;
                while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'9'<=0) i++;
                numStack.push(flag*Integer.parseInt(s.substring(index,i)));
                flag = 1;
                index = i;
                if(index==s.length())   break;
            }
            if(s.charAt(index)!=')'){
                while(!opStack.isEmpty() && lessOrEqualPriority(s.charAt(index),opStack.peek())){
                    numStack.push(compute(numStack.pop(),numStack.pop(),opStack.pop()));
                }
                opStack.push(s.charAt(index));
            }else{
                while(opStack.peek()!='(')  numStack.push(compute(numStack.pop(),numStack.pop(),opStack.pop()));
                opStack.pop();
            }
            index++;
        }
        while(!opStack.isEmpty())   numStack.push(compute(numStack.pop(),numStack.pop(),opStack.pop()));
        System.out.println(numStack.pop());
    }
    private static boolean lessOrEqualPriority(char cur,char top){
        if(top=='(' || cur=='(' || ((cur=='*' || cur=='/') && (top=='+' || top=='-')))    return false;
        return true;
    }
    private static int compute(int a,int b,char op){
        if(op=='+') return a+b;
        if(op=='-') return b-a;
        if(op=='*') return a*b;
        return b/a;
    }
}
