package OODesign.LC271EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

public class Solution271 {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder header = new StringBuilder("s");
            StringBuilder sb = new StringBuilder();
            for(String str:strs){
                header.append(str.length()).append(",");
                sb.append(str);
            }
            header.append("e");
            return header.toString()+sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            int i=1;
            while(i<s.length() && s.charAt(i)!='e') i++;
            String[] lens = s.substring(1,i++).split(",");
            List<String> ans = new ArrayList<>();
            for(int j=0;j<lens.length;++j){
                int curlen = Integer.parseInt(lens[j]);
                ans.add(s.substring(i,i+curlen));
                i += curlen;
            }
            return ans;
        }
    }

}
