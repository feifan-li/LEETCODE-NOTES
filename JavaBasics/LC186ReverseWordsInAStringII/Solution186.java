package JavaBasics.LC186ReverseWordsInAStringII;

public class Solution186 {
    public void reverseWords(char[] s) {
        //O(1) space complexity
        int n = s.length;
        //reverse the entire char[] in-place
        for(int i=0;i<n/2;++i){
            char c = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = c;
        }
        int start = 0, end = 0;
        while(end<n){
            //reach the end of a word
            while(end<n && s[end]!=' '){
                end++;
            }
            //reverse the word
            for(int i=0;i<(end-start)/2;++i){
                char c = s[start+i];
                s[start+i] = s[end-1-i];
                s[end-1-i] = c;
            }
            //move to the start of next word
            end = end+1;
            start = end;
        }
        return;
    }
}
