package LC158ReadNCharactersGivenread4II_CallMultipleTimes;

public class Solution158 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int p = 0;//next empty index of buf <=> buf's valid length
    public char[] buf4 = new char[4];
    public int p4 = 0;//next unread index of buf4 <=> length of chars already read from buf4 by read()
    public int num4 = 0;//actual number of chars read by read4() <=> buf4's valid length
    public int read(char[] buf, int n) {
        p = 0;//every time read() is called, write to buf from begining
        while(p<n){
            int remaining = n-p;
            if(p4<num4){
                for(int cnt=0;cnt<Math.min(num4-p4,remaining);++cnt){
                    buf[p++] = buf4[p4+cnt];
                }
                p4 = p4+Math.min(num4-p4,remaining);
            }else{
                num4 = read4(buf4);
                p4 = 0;
                if(num4==0) return p;
                for(int cnt=0;cnt<Math.min(num4,remaining);++cnt){
                    buf[p++] = buf4[cnt];
                }
                p4 = p4+Math.min(num4,remaining);
            }
        }
        return p;
    }
}
