package LC451SortCharactersByFrequency;

import java.util.Arrays;

public class Solution451 {
    public String frequencySort(String s) {
        int[][] freq = new int[75][2];
        for(int i=0;i<75;++i){
            freq[i][0] = i;
        }
        for(char c:s.toCharArray()){
            freq[c-'0'][1]++;
        }
        Arrays.sort(freq,(a, b)->(b[1]-a[1]));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<75;++i){
            if(freq[i][1]==0){
                break;
            }
            char c = (char)('0'+freq[i][0]);
            for(int cnt = 0;cnt < freq[i][1]; ++cnt){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
