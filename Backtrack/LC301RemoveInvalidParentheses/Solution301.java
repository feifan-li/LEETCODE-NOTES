package Backtrack.LC301RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>(); //注意res内的String都必须是有效的
        backtrack(res,s,0,0,new char[]{'(',')'});
        return res;
    }
    public void backtrack(List<String> res,String s,int lastI,int lastJ,char[] pair){
        for(int i=lastI,count = 0;i<s.length();++i){
            if(s.charAt(i)==pair[0])    count++;
            if(s.charAt(i)==pair[1])    count--;
            if(count>=0)    continue;
            //未配对的pair[1]出现：
            for(int j = lastJ;j<=i;++j){
                if(s.charAt(j)==pair[1] && (j==lastJ || s.charAt(j-1)!=pair[1])){
                    backtrack(res,s.substring(0,j)+s.substring(j+1),i,j,pair);
                }
            }
            return;
        }
        String rev = new StringBuilder(s).reverse().toString();
        if(pair[0]=='(')    backtrack(res,rev,0,0,new char[]{')','('}); //反向检查一遍！
        else    res.add(rev);   //已经反向检查过了 则加入答案
    }
}
