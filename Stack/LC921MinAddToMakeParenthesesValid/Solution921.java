package Stack.LC921MinAddToMakeParenthesesValid;

public class Solution921 {
    public int minAddToMakeValid(String s) {
        int[] leftP = new int[1000];
        int unpaired = 0, top = -1;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='(')    leftP[++top] = i;
            else{
                if(top>=0)  top--;//pop a '('
                else unpaired++;
            }
        }
        return unpaired+top+1;
    }
}
