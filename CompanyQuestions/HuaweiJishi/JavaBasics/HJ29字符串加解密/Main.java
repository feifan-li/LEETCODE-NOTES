package CompanyQuestions.HuaweiJishi.JavaBasics.HJ29字符串加解密;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s1 = in.next().toCharArray();
        char[] s2 = in.next().toCharArray();
        System.out.println(encode(s1));
        System.out.println(decode(s2));
    }
    private static String encode(char[] s){
        for(int i=0;i<s.length;++i){
            if(s[i]-'0'>=0 && s[i]-'9'<=0){
                s[i] = (char)('0'+(s[i]-'0'+1)%10);
            }
            else if(s[i]-'a'>=0 && s[i]-'z'<=25){
                s[i] = (char)('A'+(s[i]-'a'+1)%26);
            }
            else if(s[i]-'A'>=0 && s[i]-'Z'<=25){
                s[i] = (char)('a'+(s[i]-'A'+1)%26);
            }
        }
        return String.valueOf(s);
    }
    private static String decode(char[] s){
        for(int i=0;i<s.length;++i){
            if(s[i]-'0'>=0 && s[i]-'9'<=0){
                if(s[i]=='0') s[i] = '9';
                else s[i] = (char)('0'+(s[i]-'0'-1)%10);
            }
            else if(s[i]-'a'>=0 && s[i]-'z'<=25){
                if(s[i]=='a') s[i] = 'Z';
                else s[i] = (char)('A'+(s[i]-'a'-1)%26);
            }
            else if(s[i]-'A'>=0 && s[i]-'Z'<=25){
                if(s[i]=='A') s[i] = 'z';
                else s[i] = (char)('a'+(s[i]-'A'-1)%26);
            }
        }
        return String.valueOf(s);
    }
}
