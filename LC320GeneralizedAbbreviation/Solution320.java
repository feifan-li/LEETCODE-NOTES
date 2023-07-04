package LC320GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution320 {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        if(word.length()==1){
            ans.add(word);
            ans.add("1");
            return ans;
        }
        List<String> suffices = generateAbbreviations(word.substring(1));
        for(String suffix:suffices){
            ans.add(word.charAt(0)+suffix);
            if(suffix.charAt(0)-'0'>=0 && suffix.charAt(0)-'9'<=0){
                if(suffix.length()==1 || !(suffix.charAt(1)-'0'>=0 && suffix.charAt(1)-'9'<=0)){
                    ans.add((((suffix.charAt(0)-'0')+1)+"")+suffix.substring(1));
                }else if(suffix.length()>1 && suffix.charAt(1)-'0'>=0 && suffix.charAt(1)-'9'<=0){
                    ans.add((Integer.parseInt(suffix.substring(0,2))+1+"")+suffix.substring(2));
                }
            }else   ans.add((1+"")+suffix);
        }
        return ans;
    }
}
