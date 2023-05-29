package CompanyQuestions.HuaweiJishi.JavaBasics.HJ74参数解析;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.trim();
        int i = 0;
        ArrayList<String> ans = new ArrayList<>();
        while(i<s.length()){
            if(s.charAt(i)==' ')    i++;
            if(s.charAt(i)!='"'){
                StringBuilder sb = new StringBuilder();
                while(i<s.length() && s.charAt(i)!=' '){
                    sb.append(s.charAt(i));
                    i++;
                }
                ans.add(sb.toString());
                i++;
            }else{
                StringBuilder sb = new StringBuilder();
                i++;
                while(i<s.length() && s.charAt(i)!='"'){
                    sb.append(s.charAt(i));
                    i++;
                }
                ans.add(sb.toString());
                i++;
            }
        }
        System.out.println(ans.size());
        for(int j=0;j<ans.size();++j){
            System.out.println(ans.get(j));
        }
    }
}
