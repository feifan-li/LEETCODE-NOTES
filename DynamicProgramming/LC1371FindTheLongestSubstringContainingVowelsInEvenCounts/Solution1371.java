package DynamicProgramming.LC1371FindTheLongestSubstringContainingVowelsInEvenCounts;

import java.util.Arrays;

public class Solution1371 {
    public int findTheLongestSubstring(String s) {
        int state = 0, ans = 0;//initially all counts of vowels are even(0)
        char[] arr = s.toCharArray();
        int[] map = new int[32];//0x00000~0x11111
        Arrays.fill(map,-2);
        map[state] = -1;
        for(int i=0;i<s.length();++i){
            //state records the eveness/oddness of each vowel in substring [0,i]
            //we iterate through index i to see the longest substring with even counts of all vowels
            //by checking the first recorded previous state that equals current state.
            state ^= !isVowel(arr[i])?0:(1<<("aeiou".indexOf(arr[i])));//modulo 2 addition
            if(map[state]==-2)  map[state] = i;
            ans = Math.max(ans,i-map[state]);
        }
        return ans;
    }
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    /**
     Input: A string
     Output: The length of the longest substring where each kind of vowel appear even times
     Need to Clarify:
        1) What is the minimum and maximum length of input string?
        2) Does the input string contains uppercase vowels?
     Solution:
        Intuition1: even number add or minus even number is still even, odd number add or minus odd number will become even.
        Therefore, we don't need to consider the exact counts of each vowel, only the evenness or oddness matters;
        Further, we can iterate through every index i to see the longest required substring that ends with i, by checking the evenness and oddness of this substring;

        Intuition2: once we know the evenness and oddness of every substring s[0,i], i=0,...,s.len-1, we can easily know the evenness and oddness
        of every substring.
        Therefore, we can keep the states of substrings s[0,i], represented by 5 bits is sufficient;
     **/
}
