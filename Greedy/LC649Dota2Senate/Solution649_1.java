package Greedy.LC649Dota2Senate;

public class Solution649_1 {
    public static String predictPartyVictory(String s) {
        //Greedy:current senate ban his next senate who belongs to another party
        int n = s.length();
        boolean[] banned = new boolean[n];
        int rCnt = 0;
        int dCnt = 0;
        for(int i = 0;i<n;++i){
            rCnt += s.charAt(i)=='R'?1:0;
            dCnt += s.charAt(i)=='D'?1:0;
        }
        if(dCnt==0 && rCnt!=0) return new String("Radiant");
        if(dCnt!=0 && rCnt==0) return new String("Dire");
        while(rCnt!=0 && dCnt!=0){
            for(int i = 0;i<n;++i){
                if(banned[i]) continue;
                char cur = s.charAt(i);
                if(cur=='R'){
                    if(dCnt==0 && rCnt!=0) return new String("Radiant");
                    for(int steps=1;steps<=n;++steps){
                        int j = (i+steps)%(n);
                        if(!banned[j] && s.charAt(j)=='D'){
                            banned[j] = true;
                            dCnt--;
                            if(dCnt==0 && rCnt!=0) return new String("Radiant");
                            break;
                        }
                    }
                }else if(cur=='D'){
                    if(dCnt!=0 && rCnt==0) return new String("Dire");
                    for(int steps=1;steps<=n;++steps){
                        int j = (i+steps)%(n);
                        if(!banned[j] && s.charAt(j)=='R'){
                            banned[j] = true;
                            rCnt--;
                            if(dCnt!=0 && rCnt==0) return new String("Dire");
                            break;
                        }
                    }
                }
            }
            System.out.println(banned.toString());
        }
        if(rCnt==0 && dCnt!=0){
            return new String("Dire");
        }
        if(rCnt!=0 && dCnt==0){
            return new String("Radiant");
        }
        return "Error";
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RRDDD"));
    }
}
