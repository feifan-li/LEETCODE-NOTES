package BitManipulation.LC405ConvertANumberToHexadecimal;

public class Solution405 {
    public String toHex(int num) {
        long val = num;
        if(num==0)  return "0";
        if(num<0)   val = (1L<<32)+num;
        StringBuilder sb = new StringBuilder();
        while(val>0){
            long last = val - 16*(val/16);
            val = val/16;
            if(last<=9) sb.append((int)last);
            else sb.append((char)(((int)last-10)+'a'));
        }
        return sb.reverse().toString();
    }
}
