package DynamicProgramming.LC1218LongestArithmeticSubsequenceofGivenDifference;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int d) {
        int max = 1;
        int[] map = new int[40009];//length of longest a.s. end with given value, when access, need to add offset
        for(int i=0;i<arr.length;++i){
            int prevLen = map[arr[i]-d+20000];
            if(prevLen+1>map[arr[i]+20000]){
                map[arr[i]+20000] = prevLen+1;
                max = Math.max(max,prevLen+1);
            }
        }
        return max;
    }
}
