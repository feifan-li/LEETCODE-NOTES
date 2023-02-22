package BitManipulation.LC2235AddTwoIntegers;
//https://leetcode.com/problems/add-two-integers/description/
public class Solution2235 {
    public static int sum(int a, int b) {
        while(b!=0){
            int sum = a^b;//模2加法
            b = (a&b)<<1;//进位信息
            a = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(sum(-10,4));
    }
}
