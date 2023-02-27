package LC68TextJustification;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<String>();
        int n = words.length;
        LinkedList<String> lineWords = new LinkedList<>();
        int curLineLen;
        int curTextLen;
        int index = 0;
        while(index<n){
            curLineLen = 0;curTextLen = 0;
            while(index<n && curLineLen<=maxWidth){
                if(lineWords.isEmpty()) curLineLen = words[index].length();
                else curLineLen = curLineLen+1+words[index].length();
                if(curLineLen<=maxWidth){
                    lineWords.add(words[index]);
                    curTextLen += words[index].length();
                    index++;
                }
            }
            int gaps;
            if(index==n) gaps = lineWords.size();
            else gaps = lineWords.size()-1==0? 1:lineWords.size()-1;
            System.out.println(gaps);
            int spaces = (maxWidth-curTextLen);

            StringBuilder sb = new StringBuilder();
            int size = lineWords.size();
            for(int i=1;i<=size;i++){
                String word = lineWords.removeFirst();
                sb.append(word);
                if(index==n){
                    if(i!=size){
                        sb.append(" ");
                    }else if(i==size){
                        for(int j=1;j<=spaces-(gaps-1);++j){sb.append(" ");}
                    }
                }else{
                    if(i<=spaces%gaps){
                        for(int j=1;j<=spaces/gaps+1;++j){sb.append(" ");}
                    }else if(i<=gaps){
                        for(int j=1;j<=spaces/gaps;++j){sb.append(" ");}
                    }
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
