package CompanyQuestions.HuaweiJishi.JavaBasics.HJ86求最大连续bit数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        while(in.hasNextInt()){
            int x = in.nextInt();
            String s = Integer.toBinaryString(x);
            if(x==0){
                ans.add(0);
                continue;
            }
            int max = 0;
            int cnt = 0;
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)=='1'){
                    cnt++;
                    max = Math.max(max,cnt);
                }else cnt = 0;
            }
            ans.add(max);
        }
        for(int i=0;i<ans.size();++i){
            System.out.println(ans.get(i));
        }
    }
}
