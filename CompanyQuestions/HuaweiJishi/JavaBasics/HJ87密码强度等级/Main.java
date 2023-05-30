package CompanyQuestions.HuaweiJishi.JavaBasics.HJ87密码强度等级;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int score = 0;
        String s = in.next();
        if(s.length()<=4){
            score += 5;
        }else if(s.length()>=5 && s.length()<=7){
            score += 10;
        }else if(s.length()>=8){
            score += 25;
        }
        int lowerLetters = 0, upperLetters = 0, digits = 0, others = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'9'<=0)    digits++;
            else if(s.charAt(i)-'A'>=0 && s.charAt(i)-'Z'<=0)   upperLetters++;
            else if(s.charAt(i)-'a'>=0 && s.charAt(i)-'z'<=0)   lowerLetters++;
            else others++;
        }
        int letters = lowerLetters+upperLetters;
        if(lowerLetters==0 && upperLetters>0){
            score += 10;
        }else if(lowerLetters>0 && upperLetters==0){
            score += 10;
        }else if(lowerLetters>0 && upperLetters>0){
            score += 20;
        }
        if(digits==1){
            score += 10;
        }else if(digits>1){
            score += 20;
        }
        if(others==1){
            score += 10;
        }else if(others>1){
            score += 25;
        }
        //rewards:
        if(lowerLetters>0 && upperLetters>0 && digits>0 && others>0){
            score += 5;
        }else if(letters>0 && digits>0 && others>0){
            score += 3;
        }else if(letters>0 && digits>0){
            score += 2;
        }
        //ouput:
        if(score>=90)   System.out.println("VERY_SECURE");
        else if(score>=80)   System.out.println("SECURE");
        else if(score>=70)   System.out.println("VERY_STRONG");
        else if(score>=60)   System.out.println("STRONG");
        else if(score>=50)   System.out.println("AVERAGE");
        else if(score>=25)   System.out.println("WEAK");
        else if(score>=0)   System.out.println("VERY_WEAK");
    }
}
