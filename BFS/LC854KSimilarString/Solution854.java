package BFS.LC854KSimilarString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//Strings s1 and s2 are k-similar (for some non-negative integer k) if we can swap the positions of two letters in s1 exactly k times so that the resulting string equals s2.
//Given two anagrams s1 and s2, return the smallest k for which s1 and s2 are k-similar.
public class Solution854 {
    public static int kSimilarity(String s1, String s2) {
        int n = s1.length();
        Queue<String> q = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>(); //用于剪枝处理
        HashSet<String> visited = new HashSet<>();
        q.offer(s1);map.put(s1,0);visited.add(s1);

        int k = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=1;i<=sz;++i){
                String cur = q.poll();
                int index = map.get(cur); // cur.sub(0,index-1) = s2.subStr(0,index-1)
                if(cur.equals(s2)) return k;
                while(index < n && cur.charAt(index) == s2.charAt(index)){
                    index++;
                }// cur.sub(0,index-1) = s2.subStr(0,index-1), cur.charAt(index) != s2.charAt(index)
                for(int j=index+1;j<n;++j){
                    if(s2.charAt(index) == cur.charAt(j)){
                        String next = swap(cur,index,j);
                        if(!visited.contains(next)){
                            q.offer(next);
                            map.put(next,index+1);
                            visited.add(next);
                        }
                    }
                }
            }
            k++;
        }
        return k;
    }
    public static String swap(String s,int i,int j){
        char[] c = s.toCharArray();
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(kSimilarity("ab","ba"));
        System.out.println(kSimilarity("abc","bca"));
        System.out.println(kSimilarity("bccaba","abacbc"));
    }
}
