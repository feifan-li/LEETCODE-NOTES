package CompanyQuestions.HuaweiJishi.Greedy.HJ45名字的漂亮度;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        for(int i=0;i<n;++i){
            strs[i] = in.next();
        }
        for(int i=0;i<n;++i){
            System.out.println(getBeauty(strs[i]));
        }
    }
    private static long getBeauty(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            map.put(toLower(s.charAt(i)),map.getOrDefault(toLower(s.charAt(i)),0)+1);
        }
        ArrayList<Integer> ranks = new ArrayList<>();
        for(Map.Entry<Character,Integer> pair:map.entrySet()){
            ranks.add(pair.getValue());
        }
        ranks.sort((a,b)->b-a);
        long ans = 0;
        int beauty = 26;
        for(int i=0;i<ranks.size();++i){
            ans += beauty*ranks.get(i);
            beauty--;
        }
        return ans;
    }
    private static char toLower(char c){
        if(c-'A'>=0 && c-'Z'<=0){
            return (char)('a'+c-'A');
        }
        return c;
    }
}
