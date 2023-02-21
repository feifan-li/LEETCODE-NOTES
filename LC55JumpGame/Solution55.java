package LC55JumpGame;

public class Solution55 {
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i=0;i<nums.length-1;++i){
            farthest = Math.max(farthest,i+nums[i]);
            if(farthest<=i) return false;
        }
        return farthest >= nums.length-1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
