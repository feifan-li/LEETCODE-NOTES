package Backtrack.LC131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    //backtrack
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s.length()==1){
            list.add(s);
            ans.add(list);
            return ans;
        }
        backtrack(ans,list,s);
        return ans;
    }
    public static void backtrack(List<List<String>> ans, List<String> list, String s){
        if(s.length()==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        //make choices
        for(int i=0;i<s.length();++i){
            if(isPalindrome(s.substring(0,i+1))){
                list.add(s.substring(0,i+1));
                backtrack(ans,list,s.substring(i+1));
                list.remove(list.size()-1);
            }
        }
        return;
    }
    public static boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;++i){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
