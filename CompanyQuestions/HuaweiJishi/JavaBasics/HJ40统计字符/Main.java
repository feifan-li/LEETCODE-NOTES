package CompanyQuestions.HuaweiJishi.JavaBasics.HJ40统计字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int letters = 0, spaces = 0, digits = 0,others = 0;
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(c==' '){
                spaces ++;
                continue;
            }else if(c-'0'>=0 && c-'9'<=0){
                digits++;
                continue;
            }else if((c-'a'>=0 && c-'z'<=0)||(c-'A'>=0 && c-'Z'<=0)){
                letters++;
                continue;
            }else{
                others++;
            }
        }
        System.out.println(letters);
        System.out.println(spaces);
        System.out.println(digits);
        System.out.println(others);
    }
}
