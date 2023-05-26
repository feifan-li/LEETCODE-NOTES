package CompanyQuestions.HuaweiJishi.HJ63DNA序列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int N = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();//ratio->start of substring
        int cnt = 0;
        for(int i=0;i<Math.min(N,s.length());++i){
            if(s.charAt(i)=='C' || s.charAt(i)=='G')    cnt++;
        }
        map.put(cnt,new ArrayList<Integer>());
        map.get(cnt).add(0);
        int left = 1,right = N,max = cnt;
        while(right<s.length()){
            if(s.charAt(right)=='C' || s.charAt(right)=='G')    cnt++;
            if(s.charAt(left-1)=='C' || s.charAt(left-1)=='G')  cnt--;
            if(!map.containsKey(cnt)){
                map.put(cnt,new ArrayList<Integer>());
            }
            map.get(cnt).add(left);
            max = Math.max(max,cnt);
            left++;
            right++;
        }
        System.out.println(s.substring(map.get(max).get(0),map.get(max).get(0)+N));
    }
}
