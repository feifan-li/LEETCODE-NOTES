package CompanyQuestions.HuaweiJishi.HJ23删除字符串中出现次数最少的字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] freq = new int[26];
        String s = in.nextLine();
        for(int i=0;i<s.length();++i)   freq[s.charAt(i)-'a'] += 1;
        int min = Integer.MAX_VALUE;
        for(int f:freq) {
            if(f!=0)    min = Math.min(min,f);//O(1)
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(freq[c-'a']!=min)    sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
