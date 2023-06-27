package LC299BullsAndCows;

public class Solution299 {
    public String getHint(String secret, String guess) {
        int[] freq = new int[10];
        char[] sarr = secret.toCharArray();
        char[] garr = guess.toCharArray();
        int bulls = 0, cows = 0;
        for(int i=0;i<secret.length();++i){
            freq[sarr[i]-'0']++;
        }
        for(int i=0;i<guess.length();++i){
            if(garr[i]==sarr[i]){
                bulls++;
                freq[sarr[i]-'0']--;
            }
        }
        for(int i=0;i<guess.length();++i){
            if(garr[i]!=sarr[i] && freq[garr[i]-'0']>0){
                cows++;
                freq[garr[i]-'0']--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
