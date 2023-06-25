package FlipGame.LC293FlipGame;

import java.util.ArrayList;
import java.util.List;

public class Solution293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length()-1;++i){
            if(arr[i]=='+' && arr[i+1]=='+'){
                arr[i]='-';
                arr[i+1]='-';
                ans.add(new String(arr));
                arr[i]='+';
                arr[i+1]='+';
            }
        }
        return ans;
    }
}
