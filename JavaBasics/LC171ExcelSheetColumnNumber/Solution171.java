package JavaBasics.LC171ExcelSheetColumnNumber;

public class Solution171 {
    public final int[] pow26 = new int[7];
    public int titleToNumber(String column) {
        int ans = 0;
        pow26[0] = 1;
        for(int i=1;i<7;++i){
            pow26[i] = 26*pow26[i-1];
        }
        for(int i=0;i<column.length();++i){
            ans += (column.charAt(i)-'A'+1)*pow26[column.length()-1-i];
        }
        return ans;
    }
}
