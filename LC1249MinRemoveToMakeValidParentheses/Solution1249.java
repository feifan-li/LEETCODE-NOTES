package LC1249MinRemoveToMakeValidParentheses;

public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int[] leftP = new int[s.length()];//position of '(' in sb
        int top = -1;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==')' && top>=0){
                top--;
                sb.append(')');
            }else if(s.charAt(i)=='('){
                sb.append('(');
                leftP[++top] = sb.length()-1;
            }else if(s.charAt(i)!=')')  sb.append(s.charAt(i));
        }
        while(top>=0)     sb.replace(leftP[top],leftP[top--]+1,"");
        return sb.toString();
    }
}
