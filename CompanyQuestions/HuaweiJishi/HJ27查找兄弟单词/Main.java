package CompanyQuestions.HuaweiJishi.HJ27查找兄弟单词;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 兄弟单词：组成相同但顺序不能相同
        int n = in.nextInt();
        String[] dict = new String[n];
        for(int i=0;i<n;++i){
            dict[i] = in.next();
        }
        String x = in.next();
        int k = in.nextInt();
        int xlen = x.length();
        HashMap<Character,Integer> xChars = new HashMap<>();
        for(int i=0;i<xlen;++i){
            xChars.put(x.charAt(i),xChars.getOrDefault(x.charAt(i),0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>();
        for(String s:dict){
            if(s.length()!=xlen)    continue;
            HashMap<Character,Integer> sChars = new HashMap<>();
            boolean unqualified = false;
            for(int i=0;i<s.length();++i){
                char c = s.charAt(i);
                if(!xChars.containsKey(c)){
                    unqualified = true;
                    break;
                }
                sChars.put(c,sChars.getOrDefault(c,0)+1);
                if(sChars.get(c)>xChars.get(c)){
                    unqualified = true;
                    break;
                }
            }
            if(unqualified) continue;
            if(s.equals(x)) continue;
            heap.offer(s);
        }
        System.out.println(heap.size());
        if(heap.size()<k){
            return;
        }
        for(int i=1;i<k;++i){
            heap.poll();
        }
        System.out.println(heap.poll());
    }
}
