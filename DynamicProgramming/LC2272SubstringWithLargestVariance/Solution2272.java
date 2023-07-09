package DynamicProgramming.LC2272SubstringWithLargestVariance;

public class Solution2272 {
    public int largestVariance(String s) {
        int[] cnt = new int[26];
        char[] arr = s.toCharArray();
        for(char c:arr) cnt[c-'a']++;
        int max = 0;
        for(int i=0;i<26;++i){
            for(int j=0;j<26;++j){
                if(i==j || cnt[i]==0 || cnt[j]==0)  continue;
                char major = (char)(i+'a'), minor = (char)(j+'a');
                int majorCnt = 0, minorCnt = 0, restMinorCnt = cnt[j];
                for(char c:arr){
                    if(c==major)    majorCnt++;
                    else if(c==minor){
                        minorCnt++;
                        restMinorCnt--;
                    }
                    if(majorCnt>0 && minorCnt>0)  max = Math.max(max,majorCnt-minorCnt);
                    if(majorCnt<minorCnt && restMinorCnt>0){
                        majorCnt = 0;
                        minorCnt = 0;
                    }
                }
            }
        }
        return max;
    }
}
