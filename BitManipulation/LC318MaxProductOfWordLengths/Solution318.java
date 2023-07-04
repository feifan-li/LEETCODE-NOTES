package BitManipulation.LC318MaxProductOfWordLengths;

public class Solution318 {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bitMaps = new int[words.length];
        for(int i=0;i<words.length;++i){
            for(int j=0;j<words[i].length();++j){
                bitMaps[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        for(int i=0;i<words.length-1;++i){
            for(int j=i+1;j<words.length;++j){
                if((bitMaps[i] & bitMaps[j])==0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
