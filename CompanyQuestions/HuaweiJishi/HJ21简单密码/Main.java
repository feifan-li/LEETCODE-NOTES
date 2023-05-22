package CompanyQuestions.HuaweiJishi.HJ21简单密码;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> passwords = new ArrayList<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            passwords.add(in.nextLine());
        }
        for(int i=0;i<passwords.size();++i){
            String p = passwords.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<p.length();++j){
                char c = p.charAt(j);
                if(c-'a'>=0 && c-'z'<=25){
                    sb.append(convertLowerToNum(c));
                }else if(c-'A'>=0 && c-'Z'<=25){
                    sb.append(convertUpperToLower(c));
                }else   sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
    public static char convertUpperToLower(char c){
        if(c=='Z') return 'a';
        int offset = c-'A';
        return (char)('a'+offset+1);
    }
    public static char convertLowerToNum(char c){
        if(c-'a'>=0 && c-'a'<=2){
            return '2';
        }else if(c-'a'>=3 && c-'a'<=5){
            return '3';
        }else if(c-'a'>=6 && c-'a'<=8){
            return '4';
        }else if(c-'a'>=9 && c-'a'<=11){
            return '5';
        }else if(c-'a'>=12 && c-'a'<=14){
            return '6';
        }else if(c-'a'>=15 && c-'a'<=18){
            return '7';
        }else if(c-'a'>=19 && c-'a'<=21){
            return '8';
        }
        return '9';
    }
}
