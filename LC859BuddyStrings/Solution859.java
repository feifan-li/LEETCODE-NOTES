package LC859BuddyStrings;

public class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length() || s.length()==1)  return false;
        char[] sarr = s.toCharArray();
        char[] garr = goal.toCharArray();
        int[] sfreq = new int[26];
        int i = -1, j= -1;
        for(int index = 0;index<s.length();++index){
            if(sarr[index]!=garr[index]){
                if(i==-1)   i = index;
                else if(j==-1)  j = index;
                else return false;
            }
            sfreq[sarr[index]-'a']++;
        }
        if(i==-1 && j==-1){
            for(int freq:sfreq){
                if(freq>=2) return true;
            }
            return false;
        }
        return (i!=-1 && j!=-1 && sarr[i]==garr[j] && sarr[j]==garr[i]);
    }
}
