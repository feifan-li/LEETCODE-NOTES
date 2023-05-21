package CompanyQuestions.HuaweiJishi.HJ17坐标移动;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character,int[]> dirMap = new HashMap<>();
        dirMap.put('A',new int[]{-1,0});
        dirMap.put('D',new int[]{1,0});
        dirMap.put('W',new int[]{0,1});
        dirMap.put('S',new int[]{0,-1});
        String s = in.nextLine();
        int[] ans = new int[]{0,0};
        int left = 0,right = 0;
        while(right<s.length()){
            while(right<s.length() && s.charAt(right)!=';'){
                right++;
            }
            if(isValid(s.substring(left,right))){
                int[] dir = dirMap.get(s.charAt(left));
                int offset = Integer.valueOf(s.substring(left+1,right));
                ans[0] += dir[0]*offset;
                ans[1] += dir[1]*offset;
            }
            right = right+1;
            left = right;
        }
        System.out.println(ans[0]+","+ans[1]);
    }
    private static boolean isValid(String s){
        if(s.length()>3 || s.length()<=1)   return false;
        if(s.charAt(0)!='A' && s.charAt(0)!='D' && s.charAt(0)!='W' && s.charAt(0)!='S')    return false;
        if(s.length()>=2 && !(s.charAt(1)-'0'>=0 && s.charAt(1)-'9'<=0)){
            return false;
        }
        if(s.length()==3 && !(s.charAt(2)-'0'>=0 && s.charAt(2)-'9'<=0)){
            return false;
        }
        return true;
    }
}
