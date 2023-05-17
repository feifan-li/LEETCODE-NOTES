package JavaBasics.LC161OneEditDistance;

public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length())>=2)  return false;
        for(int i=0;i<Math.min(s.length(),t.length());++i){
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length()==t.length())  return s.substring(i+1).equals(t.substring(i+1));
                if(s.length()<t.length())   return s.substring(i).equals(t.substring(i+1));
                else return s.substring(i+1).equals(t.substring(i));
            }
        }
        return s.length()==t.length()?false:true;
    }
}
