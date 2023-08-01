package Stack.LC394DecodeString;

public class Solution394 {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder[] encodedStack = new StringBuilder[30];
        int[] kStack = new int[30];
        int i = 0, k = 0, encodeStackTop = -1, kStackTop = -1;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                k=0;
                while(s.charAt(i)!='[') k = k*10 + (s.charAt(i++)-'0');
                kStack[++kStackTop] = k;
            }else if(s.charAt(i)=='['){
                encodedStack[++encodeStackTop] = ans;
                ans = new StringBuilder();
                i++;
            }else if(s.charAt(i)==']'){
                StringBuilder curDecodedString = new StringBuilder();
                int curK = kStack[kStackTop--];
                for(int cnt=0;cnt<curK;++cnt)   curDecodedString.append(ans);
                ans = encodedStack[encodeStackTop--].append(curDecodedString.toString());
                i++;
            }else{
                ans.append(s.charAt(i++));
            }
        }
        return ans.toString();
    }
}
