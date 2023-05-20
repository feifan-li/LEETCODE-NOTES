package CompanyQuestions.HuaweiJishi.JavaBasics.HJ9_提取不重复的整数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] freq = new int[10];
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] sarr = s.toCharArray();
        for(int i=sarr.length-1;i>=0;--i){
            freq[sarr[i]-'0'] += 1;
            if(freq[sarr[i]-'0']==1) sb.append(sarr[i]);
        }
        System.out.println(sb.toString());
    }
}
