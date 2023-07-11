package LC350IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.List;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[1001];
        int[] cnt2 = new int[1001];
        for(int num:nums1)  cnt1[num]++;
        for(int num:nums2)  cnt2[num]++;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=1000;++i){
            if(cnt1[i]>0 && cnt2[i]>0){
                for(int k=0;k<Math.min(cnt1[i],cnt2[i]);++k)    ans.add(i);
            }
        }
        int[] res = new int[ans.size()];
        int i=0;
        for(int num:ans)    res[i++] = num;
        return res;
    }
}
