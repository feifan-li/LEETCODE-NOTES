package CompanyQuestions.HuaweiJishi.HJ36字符串加密;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String key = in.next();
        String s = in.next();
        char[] newAlphabet = new char[26];
        int i = 0,j = 0;
        HashSet<Character> set = new HashSet<>();
        for(i=0;i<key.length();++i){
            if(!set.contains(key.charAt(i))){
                newAlphabet[j] = key.charAt(i);
                j++;
            }
            set.add(key.charAt(i));
        }
        i=0;
        for(j=j;j<26;++j){
            while(set.contains((char)('a'+i))){
                i++;
            }
            newAlphabet[j] = (char)('a'+i);
            i++;
        }
        char[] sEncoded = s.toCharArray();
        for(i=0;i<s.length();++i){
            int offset = sEncoded[i]-'a';
            sEncoded[i] = newAlphabet[offset];
        }
        System.out.println(String.valueOf(sEncoded));
    }
}
