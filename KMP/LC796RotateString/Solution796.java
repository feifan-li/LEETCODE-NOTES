package KMP.LC796RotateString;

public class Solution796 {
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String goal2 = goal+goal;
        return getIndexOf(goal2,s)!=-1;
    }
    public static int getIndexOf(String s1,String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] next = getNextArray(str2);
        int x=0,y=0;
        while(x<str1.length && y<str2.length){
            if(str1[x]==str2[y]){x++;y++;}
            else if(next[y]==-1) x++;
            else y = next[y];
        }
        return y==str2.length?x-y:-1;
    }
    public static int[] getNextArray(char[] str2){
        if(str2.length==1) return new int[]{-1};
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = next[i-1];
        while(i<str2.length){
            if(str2[i-1]==str2[cn]) next[i++] = ++cn;
            else if(cn>0) cn = next[cn];
            else next[i++] = 0;
        }
        return next;
    }

    public static void main(String[] args) {

    }
}
