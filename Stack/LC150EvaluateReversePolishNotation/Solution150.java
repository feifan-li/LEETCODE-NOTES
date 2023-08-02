package Stack.LC150EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[10000];
        int top = -1;
        for(int i=0;i<tokens.length;++i){
            if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
                int num = Integer.parseInt(tokens[i]);
                stack[++top] = num;
            }else{
                int y = stack[top--];
                int x = stack[top--];
                if(tokens[i].equals("+")) stack[++top] = x+y;
                else if(tokens[i].equals("-")) stack[++top] = x-y;
                else if(tokens[i].equals("*")) stack[++top] = x*y;
                else if(tokens[i].equals("/")) stack[++top] = x/y;
            }
        }
        return stack[top];
    }
}
