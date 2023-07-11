package LC349IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.List;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] set1 = new int[1001];
        int[] set2 = new int[1001];
        for(int num:nums1)  set1[num]=1;
        for(int num:nums2)  set2[num]=1;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=1000;++i){
            if(set1[i]==1 && set2[i]==1)    ans.add(i);
        }
        int[] res = new int[ans.size()];
        int i=0;
        for(int num:ans)    res[i++] = num;
        return res;
    }
}
