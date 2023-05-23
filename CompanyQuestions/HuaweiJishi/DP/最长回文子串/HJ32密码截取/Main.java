package CompanyQuestions.HuaweiJishi.DP.最长回文子串.HJ32密码截取;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //最长回文子串
        char[] arr = new char[2*s.length()+1];
        for(int i=0;i<arr.length;++i){
            if(i%2==0) arr[i] = '*';
            else arr[i] = s.charAt(i/2);
        }
        int dp = 1;
        for(int i=1;i<arr.length-1;++i){
            int left = i-1;
            int right = i+1;
            while(left>=0 && right<arr.length && arr[left]==arr[right]){
                left--;
                right++;
            }
            dp = Math.max(dp,right-left-1);
        }
        System.out.println(dp/2);
    }
}
