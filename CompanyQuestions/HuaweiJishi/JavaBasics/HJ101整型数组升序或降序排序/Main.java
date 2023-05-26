package CompanyQuestions.HuaweiJishi.JavaBasics.HJ101整型数组升序或降序排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] nums = new Integer[n];
        for(int i=0;i<n;++i){
            nums[i] = in.nextInt();
        }
        int flag = in.nextInt();
        Arrays.sort(nums);
        if(flag==0){
            Arrays.sort(nums);
        }else if(flag==1){
            Arrays.sort(nums, Collections.reverseOrder());
        }
        for(int i=0;i<n-1;++i){
            System.out.print(nums[i]+" ");
        }
        System.out.println(nums[n-1]);
    }
}
