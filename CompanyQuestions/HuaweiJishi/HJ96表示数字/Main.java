package CompanyQuestions.HuaweiJishi.HJ96表示数字;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)-'0'>=0 && s.charAt(0)-'9'<=0)    sb.append('*');
        int i=0;
        while(i<s.length()){
            sb.append(s.charAt(i));
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'9'<=0){
                if(i==s.length()-1 || !(s.charAt(i+1)-'0'>=0 && s.charAt(i+1)-'9'<=0)){
                    sb.append('*');
                }
            }else{
                if(i<s.length()-1 && (s.charAt(i+1)-'0'>=0 && s.charAt(i+1)-'9'<=0)){
                    sb.append('*');
                }
            }
            i++;
        }
        System.out.println(sb.toString());
    }
}
