package LC1165SingleRowKeyboard;

public class Solution1165 {
    public int calculateTime(String keyboard, String word) {
        assert keyboard.length()==26;
        int[] pos = new int[26];
        for(int i=0;i<26;++i){
            pos[keyboard.charAt(i)-'a'] = i;
        }
        int time = 0, prev = 0;
        for(char c:word.toCharArray()){
            time += Math.abs(pos[c-'a']-prev);
            prev = pos[c-'a'];
        }
        return time;
    }
}
