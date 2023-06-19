package Backtrack.LC267PalindromePermutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution267 {
    public static List<String> generatePalindromes(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;++i)    freq[s.charAt(i)-'a']++;
        if(n%2==0){
            for(int i=0;i<26;++i){
                if(freq[i]%2==1)    return new ArrayList<String>();
            }
        }else{
            int odds = 0;
            for(int i=0;i<26;++i){
                if(freq[i]%2==1 && odds==1)    return new ArrayList<String>();
                else if(freq[i]%2==1 && odds==0)    odds++;
            }
        }
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return backtrack(String.valueOf(c),freq);
    }
    public static List<String> backtrack(String s, int[] freq){
        List<String> retList = new ArrayList<String>();
        if(s.length()==1 || s.length()==2){
            retList.add(s);
            return retList;
        }
        int i=0;
        while(i<s.length()){
            if(freq[s.charAt(i)-'a']>1){
                freq[s.charAt(i)-'a'] -= 2;
                List<String> permutatedList = backtrack(s.substring(0,i)+s.substring(i+2,s.length()),freq);
                freq[s.charAt(i)-'a'] += 2;
                for(String permutated:permutatedList){
                    String ret = s.charAt(i)+permutated+s.charAt(i);
                    retList.add(ret);
                }
            }
            i = i+freq[s.charAt(i)-'a'];
        }
        return retList;
    }

    public static void main(String[] args) {
        System.out.println(generatePalindromes("bbccc"));
    }
}
