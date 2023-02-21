package LC2459SortArraybyMovingItemstoEmptySpace;
import java.util.Arrays;
public class Solution2459 {
    public int sortArray(int[] nums) {
        // 1) 0 1 2 3 4 ... min number of operations : ans1
        // 2) 1 2 3 4 ... 0 min number of operations : ans2
        int n = nums.length, ans1=0,ans2=0,m,next;
        //i 位置是否在之前的下标循环中
        boolean[] touched = new boolean[n];
        // 方案一 -> ans1
        //num 0 is expected to be put at 0
        //index i expect num i
        for(int i=0;i<n;i++){
            if(!touched[i]){
                //下标循环
                touched[i] = true;
                m=1;//计数
                next = nums[i];
                while(next!=i){
                    m++;
                    touched[next] = true;
                    next = nums[next];
                }
                //环大小m
                if(m>1){
                    //单独成环的不需要动
                    ans1 += i==0?(m-1):(m+1);
                }
            }
        }
        // 方案二 -> ans2
        Arrays.fill(touched,false);
        //num 0 is expected to be put at n-1
        //index i expect num i+1, index n-1 expect num 0
        for(int i=n-1;i>=0;i--){
            if(!touched[i]){
                touched[i] = true;
                m=1;
                next = nums[i]==0 ? (n-1) : (nums[i] - 1);
                while(next!=i){
                    m++;
                    touched[next] = true;
                    next = nums[next]==0 ? (n-1) : (nums[next] - 1);
                }
                if(m>1){
                    ans2 += i == n-1 ? (m-1):(m+1);
                }
            }
        }
        return Math.min(ans1,ans2);
    }
}
