package LC1207UniqueNumberOfOccurence;

import java.util.Arrays;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int[] freq = new int[arr.length+1];
        int i=0,j=0;
        while(i<arr.length){
            while(j<arr.length && arr[j]==arr[i]){
                j++;
            }
            freq[j-i]++;
            if(freq[j-i]>=2){
                return false;
            }
            i = j;
        }
        return true;
    }
}
