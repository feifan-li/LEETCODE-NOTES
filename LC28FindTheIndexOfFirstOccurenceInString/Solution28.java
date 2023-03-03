package LC28FindTheIndexOfFirstOccurenceInString;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        if(needle==null || n==0) return 0;
        for(int i=0;i<h;++i){
            if(i+n>h) break;
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i,i+n).equals(needle)) return i;
            }
            else continue;
        }

        return -1;
    }
}
