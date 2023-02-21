package LC205IsomorphicStrings;

import java.util.HashMap;

public class Solution205 {
    public static boolean isIsomorphic(String s, String t) {
        if(s==null || s=="" || t==null || t==""){
            return true;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(!map.containsKey(a)){
                if(map.containsValue(b)) return false;
                else map.put(a,b);
            }else{
                if(map.get(a).equals(b)) continue;
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1="paper";
        String t1="title";
        String s2="foo";
        String t2="bar";
        String s3="egg";
        String t3="add";
        System.out.println(isIsomorphic(s1,t1));//true
        System.out.println(isIsomorphic(s2,t2));//false
        System.out.println(isIsomorphic(s3,t3));//true

    }
}
