package CompanyQuestions.HJ.HJ2_计算某字符出现次数;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] sarr = s.toCharArray();
        char t = in.nextLine().charAt(0);
        HashMap<Character,Integer> map = new HashMap<>();
        //不区分大小写字母
        for(char c:sarr){
            char cLower = lower(c);
            map.put(cLower,map.getOrDefault(cLower,0)+1);
        }
        int ans = map.containsKey(lower(t))?map.get(lower(t)):0;
        System.out.println(ans);
    }
    private static char lower(char c){
        if(c-'A'>=0 && c-'Z'<=0){
            int offset = c-'A';
            return  (char)('a'+offset);
        }
        return c;
    }
}
