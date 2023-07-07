package TwoPointers.LC2024MaximizeConfusionOfAnExam;

public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] num = new int[2];
        int left = 0, right = 0, ans = 0;
        int n = answerKey.length();
        while(right<n){
            if(answerKey.charAt(right)=='F'){++num[0];}
            else{++num[1];}
            int currMax = Math.max(num[0],num[1]);
            right++;
            if(right-left-currMax > k){//currMin > k
                if(answerKey.charAt(left)=='F'){--num[0];}
                else{--num[1];}
                left++;
            }else{
                ans = Math.max(ans,right-left);
            }
        }
        return ans;
    }
}
