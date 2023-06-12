package DivideAndConquer.LC241DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<exp.length();++i){
            if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*'){
                List<Integer> leftNums = diffWaysToCompute(exp.substring(0,i));
                List<Integer> rightNums = diffWaysToCompute(exp.substring(i+1));
                for(int left:leftNums){
                    for(int right:rightNums){
                        if(exp.charAt(i)=='+')  ans.add(left+right);
                        else if(exp.charAt(i)=='-') ans.add(left-right);
                        else if(exp.charAt(i)=='*') ans.add(left*right);
                    }
                }
            }
        }
        if(ans.size() == 0)    ans.add(Integer.parseInt(exp.substring(0)));
        return ans;
    }
}
