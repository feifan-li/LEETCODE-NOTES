package LC32LongestValidParentheses;

import java.util.Stack;

public class Solution32 {
    public static int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0, start =-1;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='(') stack.push(i);
            else{
                if(stack.isEmpty()) start = i;
                else{
                    stack.pop();
                    if(stack.isEmpty()) res = Math.max(res,i-start);
                    else res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("(()"));//2
        System.out.println(longestValidParentheses(")()())"));//4
        System.out.println(longestValidParentheses(""));//0
        System.out.println(longestValidParentheses("((()()"));//4
        System.out.println(longestValidParentheses("(()())()))"));//8

    }
}
