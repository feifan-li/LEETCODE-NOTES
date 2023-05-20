package CompanyQuestions.HuaweiJishi.易错.HJ14_字符串排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        for(int i=0;i<n;++i){
            strs[i] = in.next();
        }
        Arrays.sort(strs);
        for(String s:strs){
            System.out.println(s);
        }
    }
}
