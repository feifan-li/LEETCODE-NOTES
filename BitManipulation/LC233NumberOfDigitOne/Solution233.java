package BitManipulation.LC233NumberOfDigitOne;

public class Solution233 {
    public static int countDigitOne(int n) {
        long ans = 0;
        long T = 1;
        for(int i=0;i<new String(n+"").length();++i){
            T = T*10;
            ans += ((n+1)/T)*(T/10);
            long x = (n+1)%T;
            if(x>T/10)  ans += Math.min(x,2*T/10) - T/10;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(1000000000));
    }
}
