package Strings.LC344ReverseString;

public class Solution344 {
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;++i){
            char tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
    }
}
