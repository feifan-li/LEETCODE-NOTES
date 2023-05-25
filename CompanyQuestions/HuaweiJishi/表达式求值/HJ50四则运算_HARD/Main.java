package CompanyQuestions.HuaweiJishi.表达式求值.HJ50四则运算_HARD;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replace("[","(");
        s = s.replace("{","(");
        s = s.replace("]",")");
        s = s.replace("}",")");
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int flag = 1;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='-' && (i==0 || s.charAt(i-1)=='(' || s.charAt(i-1)=='+'
                    || s.charAt(i-1)=='-' || s.charAt(i-1)=='*' || s.charAt(i-1)=='/')){
                flag = -1;
                i = i+1;
            }
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'9'<=0){
                int j = i+1;
                while(j<s.length() && s.charAt(j)-'0'>=0 && s.charAt(j)-'9'<=0){
                    j++;
                }
                numStack.push(flag*Integer.parseInt(s.substring(i,j)));
                i = j;
                flag = 1;
                if(i==s.length()) break;
            }
            if(s.charAt(i)!=')'){
                while(!opStack.isEmpty() && lessOrEqualPriorirty(s.charAt(i),opStack.peek())){
                    char op = opStack.pop();
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(compute(a,b,op));
                }
                opStack.push(s.charAt(i));
            }else{
                while(opStack.peek()!='('){
                    char op = opStack.pop();
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(compute(a,b,op));
                }
                opStack.pop();
            }
            i++;
        }
        while(!opStack.isEmpty()){
            char op = opStack.pop();
            int b = numStack.pop();
            int a = numStack.pop();
            numStack.push(compute(a,b,op));
        }
        assert numStack.size()==1;
        System.out.println(numStack.pop());
    }
    private static boolean lessOrEqualPriorirty(char cur,char top){
        if(cur=='('|| top=='(')    return false;
        else if((top=='+' || top=='-') && (cur=='*' || cur=='/'))   return false;
        return true;
    }
    private static int compute(int first,int second,char op){
        if(op=='+') return first+second;
        else if(op=='-') return first-second;
        else if(op=='*') return first*second;
        return first/second;
    }
}
