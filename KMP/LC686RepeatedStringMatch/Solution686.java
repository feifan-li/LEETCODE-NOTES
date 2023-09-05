package KMP.LC686RepeatedStringMatch;

public class Solution686 {
    /** Time Complexity = O(bLen)*/
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length(), bLen = b.length(), n = (bLen+aLen-1)/aLen;
        //将a重复2n次 O(n*aLen) = O((bLen/aLen)*aLen) = O(bLen)
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2*n;++i)   sb.append(a);
        String aRepeated = sb.toString();
        //从a重复2n次的串中查找b
        int[] next = getNextArray(b);/** O(bLen)*/
        int x = 0, y=0;
        while(x<aRepeated.length() && y<b.length()){
            if(aRepeated.charAt(x)==b.charAt(y)){
                x++;
                y++;
            }else if(y==0){
                x++;
            }else{
                y = next[y];
            }
        }/** O(n*aLen) = O((bLen/aLen)*aLen) = O(bLen)*/
        if(y!=b.length())   return -1;
        int start = (x-y)/a.length();//x-y是aRepeated中b第一次开始的位置
        int end = (x-y+b.length()-1)/a.length();//x-y+b.length()-1是aRepeated中b第一次结束的位置
        return end-start+1;//即b跨过了多少块a
    }
    public int[] getNextArray(String s){
        if(s.length()==1)   return new int[]{-1};
        int[] next = new int[s.length()];
        next[0] = -1;
        int i=2, cn = next[i-1];
        while(i<s.length()){
            if(s.charAt(i-1)==s.charAt(cn)) next[i++] = ++cn;
            else if(cn>0)   cn = next[cn];
            else next[i++] = 0;
        }
        return next;
    }
}
