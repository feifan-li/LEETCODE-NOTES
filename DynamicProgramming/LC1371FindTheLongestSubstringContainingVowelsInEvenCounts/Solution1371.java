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
}
