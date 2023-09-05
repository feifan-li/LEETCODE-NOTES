package KMP.LC28FindTheIndexOfTheFirstOccurenceInAString;

public class Solution28 {
    public int strStr(String s, String t) {
        int[] next = getNextArray(t);
        for(int ni:next)    System.out.println(ni);
        int x = 0, y = 0;
        while(x<s.length() && y<t.length()){
            if(s.charAt(x)==t.charAt(y)){
                x++;
                y++;
            }else if(y==0){
                x++;
            }else{
                y = next[y];
            }
        }
        return y==t.length()?x-y:-1;
    }
    public int[] getNextArray(String s){
        if(s.length()==1)   return new int[]{-1};
        int[] next = new int[s.length()];
        next[0] = -1;
        int i=2, cn = next[i-1];
        while(i<s.length()){
            if(s.charAt(i-1)==s.charAt(cn))   next[i++] = ++cn;
            else if(cn>0)   cn = next[cn];
            else    next[i++] = 0;
        }
        return next;
    }
}
