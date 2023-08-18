package OODesign.LC385MiniParser;

public class Solution385 {
    public NestedInteger deserialize(String s) {
        if(s.equals("[]"))  return new NestedInteger();
        if(!s.startsWith("["))  return new NestedInteger(Integer.parseInt(s));
        NestedInteger ans = new NestedInteger();
        //当前nested integer是nested list
        int unpairedBrackets = 0, start=1, end = 1;
        while(start<s.length()-1 && end<s.length()-1){
            if(s.charAt(end)=='[')  unpairedBrackets++;
            else if(s.charAt(end)==']') unpairedBrackets--;
            else if(s.charAt(end)==',' && unpairedBrackets==0){
                ans.add(deserialize(s.substring(start,end)));
                start = end+1;
                end = start;
                continue;
            }
            end++;
        }
        ans.add(deserialize(s.substring(start,end)));
        return ans;
    }
}
