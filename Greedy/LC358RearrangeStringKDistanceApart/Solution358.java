package Greedy.LC358RearrangeStringKDistanceApart;

public class Solution358 {
    public String rearrangeString(String s, int k) {
        int[] remaining = new int[26];//未被放入结果串的各字符的个数
        int[] nextIndex = new int[26];//各字符在结果串中下次可以出现的位置
        StringBuilder res = new StringBuilder();//结果串
        for(char c:s.toCharArray())   remaining[c-'a']++;
        for(int i=0;i<s.length();++i){
            int nextLetter = next(remaining,nextIndex,i);
            if(nextLetter==-1)  return "";
            res.append((char)('a'+nextLetter));
            nextIndex[nextLetter] = i+k;
            remaining[nextLetter] --;
        }
        return res.toString();
    }
    public int next(int[] remaining, int[] nextIndex, int index){
        //返回可以出现在结果串index位置的 剩余次数最多的字母(Greedy)
        int max = 0, res = -1;
        for(int i=0;i<26;++i){
            if(remaining[i]>max && nextIndex[i]<=index){
                res = i;
                max = remaining[i];
            }
        }
        return res;
    }
}
