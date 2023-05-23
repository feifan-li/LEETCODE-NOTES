package CompanyQuestions.HuaweiJishi.HJ33整数与IP地址间的转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.next();
        long num = in.nextLong();
        //step1
        String[] ipSegs = ip.split("\\.");
        assert ipSegs.length==4;
        long ipToLong = 0;
        for(int i=3;i>=0;--i){
            long cur = Long.parseLong(ipSegs[i]);
            ipToLong |= (cur<<(3-i)*8);
        }
        System.out.println(ipToLong);
        //step2
        String numToBinary = Long.toBinaryString(num);
        assert numToBinary.length()<=32;
        int[] numToBinaryArr = new int[32];
        for(int i=numToBinary.length()-1;i>=0;--i){
            numToBinaryArr[31-(numToBinary.length()-1-i)] = numToBinary.charAt(i)-'0';
        }
        int[] numToIp = new int[4];
        for(int i=0;i<4;++i){
            for(int j=8*i;j<8*i+8;++j){
                int offset = j-8*i;
                numToIp[i] |= (1<<(7-offset))&(numToBinaryArr[j]<<(7-offset));
            }
        }
        System.out.println(numToIp[0]+"."+numToIp[1]+"."+numToIp[2]+"."+numToIp[3]);
    }
}

