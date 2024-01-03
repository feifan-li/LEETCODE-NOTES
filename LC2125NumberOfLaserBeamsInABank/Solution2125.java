package LC2125NumberOfLaserBeamsInABank;

public class Solution2125 {
    public int numberOfBeams(String[] bank) {
        int beams = 0, prev = 0, cnt = 0;
        for(int i=0;i<bank.length;++i){
            for(int j=0;j<bank[i].length();++j){
                cnt += bank[i].charAt(j)=='1'?1:0;
            }
            beams += cnt*prev;
            prev = cnt==0?prev:cnt;
            cnt = 0;
        }
        return beams;
    }
}
