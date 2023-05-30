package CompanyQuestions.HuaweiJishi.Backtrack.HJ93数据分组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;++i){
            nums[i] = in.nextInt();
        }
        int sum1 = 0, sum2 = 0, sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int num:nums){
            sum += num;
            if(num%5==0){
                sum1 += num;
            }else if(num%3==0 && num%5!=0){
                sum2 += num;
            }else{
                res.add(num);
            }
        }
        if(sum%2!=0){
            System.out.println(false);
            return;
        }
        Collections.sort(res);
        System.out.println(backtrack(res,0,Math.min(sum/2-sum1,sum/2-sum2)));
    }
    public static boolean backtrack(ArrayList<Integer> res, int i, int target){
        if(target==0)   return true;
        if(target!=0 && i>=res.size())  return false;
        return backtrack(res,i+1,target) || backtrack(res,i+1,target-res.get(i));
    }
}
