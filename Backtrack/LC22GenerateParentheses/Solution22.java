package Backtrack.LC22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,n,new StringBuilder());
        return res;
    }
    public void backtrack(int leftNum, int rightNum, StringBuilder sb){
        if(leftNum==0 && rightNum==0)   res.add(sb.toString());
        else if(leftNum<0 || rightNum<0 || leftNum>rightNum)   return;
        else{
            sb.append("(");
            backtrack(leftNum-1,rightNum,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            backtrack(leftNum,rightNum-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
