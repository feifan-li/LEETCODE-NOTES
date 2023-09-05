package KMP.LC214ShortestPalindrome;

public class Solution214 {
    public static String shortestPalindrome(String s) {
        //求s从头开始的最长回文串 再把s剩下的部分拷贝后逆序地放到前面
        int n = s.length();
        if(s.length()==0 || s.length()==1)  return s;
        String sReversed = new StringBuilder(s).reverse().toString();
        String news = s + "#" + sReversed;
        //对news求next数组, 注意对next数组长度的拓展
        int[] next = getNextArray(news);
        int len = next[next.length-1]; //此处求的是news整个串的最长相等前后缀的长度
        return sReversed.substring(0,n-len)+s;
    }
    public static int[] getNextArray(String s){
        if(s.length()==1)   return new int[]{-1};
        int[] next = new int[s.length()+1]; //注意对next数组长度的拓展
        next[0] = -1;
        next[1] = 0;
        int i=2, cn = next[i-1];
        while(i<=s.length()){
            if(s.charAt(i-1)==s.charAt(cn)) next[i++] = ++cn;
            else if(cn>0)    cn = next[cn];
            else    next[i++] = 0;
        }
        return next;
    }
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
    }
}
