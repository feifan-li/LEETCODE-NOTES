package Greedy.LC316RemoveDuplicateLetters;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        if(s.length()==0)   return "";
        int[] cnt = new int[26];
        for(int i=0;i<s.length();++i)   cnt[s.charAt(i)-'a']++;
        //find the first index of the minimal char such that its suffix contains all other kinds of char
        int pos = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)<s.charAt(pos))   pos = i;
            if(--cnt[s.charAt(i)-'a']==0)   break;//here pos can be either i or some index less than i
        }
        return s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}
