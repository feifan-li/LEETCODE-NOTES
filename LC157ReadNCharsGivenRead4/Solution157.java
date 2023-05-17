package LC157ReadNCharsGivenRead4;

public class Solution157 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int p = 0;//next empty index of buf
        char[] buf4 = new char[4];
        int num4 = 0;//actual number of chars read by read4()
        while(p<=n){
            num4 = read4(buf4);
            if(num4==0) return p;
            int remaining = n-p;//remaining to read by read()
            for(int cnt=0;cnt<Math.min(num4,remaining);++cnt){
                buf[p++] = buf4[cnt];
            }
        }
        return p;
    }
}
