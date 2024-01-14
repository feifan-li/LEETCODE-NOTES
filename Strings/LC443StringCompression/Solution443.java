package Strings.LC443StringCompression;

public class Solution443 {
    public int compress(char[] chars) {
        int fast = 1;
        int slow = 1;
        char curChar = chars[0];
        char curFreq = 1;
        while(fast<chars.length){
            if(chars[fast]==curChar){
                while(fast<chars.length && chars[fast]==curChar){
                    curFreq++;
                    fast++;
                }
                String s = Integer.toString(curFreq);
                for(int i=0;i<s.length();++i) chars[slow++] = s.charAt(i);
            }else{
                curChar = chars[fast++];
                curFreq = 1;
                chars[slow++] = curChar;
            }
        }
        return slow;
    }
}
