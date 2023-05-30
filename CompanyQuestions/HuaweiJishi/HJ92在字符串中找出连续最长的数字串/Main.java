package CompanyQuestions.HuaweiJishi.HJ92在字符串中找出连续最长的数字串;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        while(in.hasNextLine()){
            strs.add(in.nextLine());
        }
        for(int i=0;i<strs.size();++i){
            ArrayList<Integer> endList = new ArrayList<>();
            String s = strs.get(i);
            int max = 0, cnt = 0;
            int j = 0;
            while(j<s.length()){
                if(s.charAt(j)-'0'>=0 && s.charAt(j)-'9'<=0){
                    cnt++;
                    if(cnt>max){
                        endList = new ArrayList<>();
                        endList.add(j);
                        max = cnt;
                    }else if(cnt==max){
                        endList.add(j);
                    }
                }else   cnt = 0;
                j++;
            }
            StringBuilder sb = new StringBuilder();
            for(int end:endList){
                sb.append(s.substring(end-max+1,end+1));
            }
            sb.append(",").append(max);
            ans.add(sb.toString());
        }
        for(String s:ans){
            System.out.println(s);
        }
    }
}
