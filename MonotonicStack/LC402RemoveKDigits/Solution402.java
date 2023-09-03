package MonotonicStack.LC402RemoveKDigits;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        char[] monoStack = new char[num.length()];
        int top = -1;
        //Greedy:每次删从左到右的第一个递增子串的最后一位
        for(int i=0;i<num.length();++i){
            while(top>=0 && monoStack[top]>num.charAt(i) && k>0){
                top--;
                k--;
            }
            monoStack[++top] = num.charAt(i);
        }
        while(k>0){
            top--;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=top;++i){
            if(sb.length()==0 && monoStack[i]=='0') continue;
            sb.append(monoStack[i]);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
