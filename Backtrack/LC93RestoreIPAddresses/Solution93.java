package Backtrack.LC93RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    public static List<String> restoreIpAddresses(String s) {
        //s consists of digits only.
        List<List<String>> ans = new ArrayList<>();
        List<String> addr = new ArrayList<>();
        if(s.length()<4) return new ArrayList<>();
        backtrack(ans,addr,s);
        List<String> ansOutput = new ArrayList<>();
        for(List<String> address:ans){
            StringBuilder sb = new StringBuilder("");
            sb.append(address.get(0)).append(".").append(address.get(1)).append(".").append(address.get(2)).append(".").append(address.get(3));
            ansOutput.add(sb.toString());
        }
        return ansOutput;
    }
    public static void backtrack(List<List<String>> ans, List<String> addr, String s){
        if(addr.size()==4 && s.length()==0){
            ans.add(new ArrayList<>(addr));
            return;
        }
        //make choices
        for(int i=0;i<Math.min(3,s.length());++i){
            String addrPart = s.substring(0,i+1);
            if(isValidInteger(addrPart)){
                addr.add(addrPart);
                backtrack(ans,addr,s.substring(i+1));
                addr.remove(addr.size()-1);
            }
        }
    }
    public static boolean isValidInteger(String s){
        //Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
        if(s.length()==1) return true;
        else if(s.length()>1 && s.length()<4){
            if(s.charAt(0)=='0') return false;
            else if(Integer.parseInt(s)>255 || Integer.parseInt(s)<0) return false;
        }else return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));
    }
}
