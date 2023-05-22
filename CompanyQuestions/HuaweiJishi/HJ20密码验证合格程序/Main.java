package CompanyQuestions.HuaweiJishi.HJ20密码验证合格程序;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> passwords = new ArrayList<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            passwords.add(s);
        }
        for(int i=0;i<passwords.size();++i){
            int a = 0,A = 0,num = 0, other = 0;
            String password = passwords.get(i);
            if(password.length()<=8){
                System.out.println("NG");
                continue;
            }
            for(int j=0;j<password.length();++j){
                if(password.charAt(j)-'a'>=0 && password.charAt(j)-'z'<=25){
                    a = 1;
                }else if(password.charAt(j)-'A'>=0 && password.charAt(j)-'Z'<=25){
                    A = 1;
                }else if(password.charAt(j)-'0'>=0 && password.charAt(j)-'9'<=9){
                    num = 1;
                }else if(password.charAt(j)!=' ' && password.charAt(j)!='\n'){
                    other = 1;
                }
            }
            if(a+A+num+other<3){
                System.out.println("NG");
                continue;
            }
            int left = 0, right = 2;
            boolean dup = false;
            while(right<password.length()){
                if(right+1<password.length() && password.substring(right+1).contains(password.substring(left,right+1))){
                    dup = true;
                    break;
                }
                left++;
                right++;
            }
            if(dup){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
}
