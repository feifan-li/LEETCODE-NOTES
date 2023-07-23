package DynamicProgramming.LC368LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] size = new int[nums.length];//size[i]: size of the largest set whose max element is nums[i]
        int[] pre = new int[nums.length];//pre[i]: index of floor(nums[i]) in largest set whose max element is nums[i]
        Arrays.fill(size,1);
        Arrays.fill(pre,-1);
        int max = 0, index = -1;//size of largest divisible set, index of the max element of this set
        for(int i=0;i<nums.length;++i){
            for(int j=i-1;j>=0;--j){
                if(nums[i]%nums[j]==0 && size[j]+1>size[i]){
                    size[i] = size[j]+1;
                    pre[i] = j;
                }
            }
            if(size[i]>max){
                max = size[i];
                index = i;
            }
        }
        while(index != -1){
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
