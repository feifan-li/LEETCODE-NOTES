package Bucket.LC164MaximumGap;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution164 {
    public class Bucket{
        public boolean used;
        public int minval;
        public int maxval;
        public Bucket(){
            used = false;
            minval = Integer.MAX_VALUE;
            maxval = Integer.MIN_VALUE;
        }
    }
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int bucketSize = Math.max(1,(max-min)/(n-1));
        int m = 1+((max-min)/bucketSize);//number of buckets
        ArrayList<Bucket> buckets = new ArrayList<>();
        for(int i=0;i<m;++i){
            buckets.add(new Bucket());
        }
        for(int num:nums){
            int bId = (num-min)/bucketSize;
            buckets.get(bId).minval = Math.min(num,buckets.get(bId).minval);
            buckets.get(bId).maxval = Math.max(num,buckets.get(bId).maxval);
            buckets.get(bId).used = true;
        }
        int maxGap = 0;
        int prevUsedBucketMax = min;
        for(int i=0;i<m;++i){
            if(buckets.get(i).used){
                maxGap = Math.max(maxGap,buckets.get(i).minval - prevUsedBucketMax);
                prevUsedBucketMax = buckets.get(i).maxval;
            }
        }
        return maxGap;
    }
}
