package CompanyQuestions.HuaweiJishi.DP.HJ65查找两个字符串ab中的最长公共子串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        if(s1.length()<=s2.length()){
            System.out.println(longestCommonSubstring(s1,s2));
        }else{
            System.out.println(longestCommonSubstring(s2,s1));
        }
    }
    private static String longestCommonSubstring(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[m+1];
        int maxlen = Integer.MIN_VALUE;
        for(int i=1;i<=m;++i){
            for(int j=i-dp[i-1];j<=i;++j){
                if(s2.contains(s1.substring(j-1,i))){
                    dp[i] = i-j+1;
                    maxlen = Math.max(maxlen,dp[i]);
                    break;
                }
            }
        }
        int end = 0;
        for(int i=1;i<=m;++i){
            if(dp[i]==maxlen){
                end = i-1;
                break;
            }
        }
        return s1.substring(end+1-maxlen,end+1);
    }
}
