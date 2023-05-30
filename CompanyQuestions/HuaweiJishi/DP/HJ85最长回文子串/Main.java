package CompanyQuestions.HuaweiJishi.DP.HJ85最长回文子串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] arr = new char[s.length()*2+1];
        for(int i=0;i<arr.length;++i){
            if(i%2==0)  arr[i] = '*';
            else arr[i] = s.charAt(i/2);
        }
        int max = 1;
        for(int i=1;i<arr.length-1;++i){
            int left = i-1;
            int right = i+1;
            while(left>=0 && right<arr.length && arr[left]==arr[right]){
                left--;
                right++;
            }
            max = Math.max(max,right-left-1);
        }
        System.out.println(max/2);
    }
}
