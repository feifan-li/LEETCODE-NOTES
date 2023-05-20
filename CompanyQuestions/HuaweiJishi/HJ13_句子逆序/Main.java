package CompanyQuestions.HuaweiJishi.HJ13_句子逆序;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        for(int i=0;i<s.length/2;++i){
            char tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
        int start = 0,end = 0;
        while(end<n){
            while(end<n && s[end]!=' '){
                end++;
            }
            for(int i=0;i<(end-start)/2;++i){
                char tmp = s[start+i];
                s[start+i] = s[end-1-i];
                s[end-1-i] = tmp;
            }
            end++;
            start = end;
        }
        System.out.println(String.valueOf(s));
    }
}
