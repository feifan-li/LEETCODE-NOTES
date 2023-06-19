package LC266PalindromePermutation;

public class Solution266 {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;++i)    freq[s.charAt(i)-'a']++;
        int odds = 0;
        if(n%2==0){
            for(int i=0;i<26;++i){
                if(freq[i]%2==1)    return false;
            }
        }else{
            for(int i=0;i<26;++i){
                if(freq[i]%2==1 && odds==1)    return false;
                else if(freq[i]%2==1 && odds==0)    odds++;
            }
        }
        return true;
    }
}
