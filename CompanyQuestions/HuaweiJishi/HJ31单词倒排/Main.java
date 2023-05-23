package CompanyQuestions.HuaweiJishi.HJ31单词倒排;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        for(int i=0;i<s.length;++i){
            if((s[i]-'a'>=0 && s[i]-'z'<=0) || (s[i]-'A'>=0 && s[i]-'Z'<=0)){
                continue;
            }else{
                s[i] = ' ';
            }
        }
        for(int i=0;i<s.length/2;++i){
            char tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
        int left = 0;
        while(s[left]==' '){
            left++;
        }
        int right = left;
        while(right<s.length){
            while(right<s.length && s[right]!=' '){
                right++;
            }
            for(int i=0;i<(right-left)/2;++i){
                char tmp = s[left+i];
                s[left+i] = s[right-1-i];
                s[right-1-i] = tmp;
            }
            right++;
            left = right;
        }
        System.out.println(String.valueOf(s).trim());
    }
}
