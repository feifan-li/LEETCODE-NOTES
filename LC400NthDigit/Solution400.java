package LC400NthDigit;

public class Solution400 {
    public int findNthDigit(int n) {
        int len = 1;//1位的数，2位的数，3位的数……
        long count = 9;//len的数一共有几个
        long start = 1;//1,10,100,1000,10000,……
        while(n>len*count){
            n -= len*count;
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1)/len;
        return Long.toString(start).charAt((n - 1) % len) - '0';
    }
}
