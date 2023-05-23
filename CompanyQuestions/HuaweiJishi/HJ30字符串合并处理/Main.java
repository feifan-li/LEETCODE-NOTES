package CompanyQuestions.HuaweiJishi.HJ30字符串合并处理;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next()+in.next();
        String s2 = step2(s1);
        String s3 = step3(s2);
        System.out.println(s3);
    }
    private static String step2(String s1){
        char[] arr = s1.toCharArray();
        char[] arrEven = new char[arr.length%2==0?arr.length/2:1+arr.length/2];
        char[] arrOdd = new char[arr.length/2];
        for(int i=0;i<arr.length;++i){
            if(i%2==0){
                arrEven[i/2] = arr[i];
            }else{
                arrOdd[i/2] = arr[i];
            }
        }
        Arrays.sort(arrEven);
        Arrays.sort(arrOdd);
        for(int i=0;i<arr.length;++i){
            if(i%2==0){
                arr[i] = arrEven[i/2];
            }else{
                arr[i] = arrOdd[i/2];
            }
        }
        return String.valueOf(arr);
    }
    private static String step3(String s2){
        char[] arr = s2.toCharArray();
        for(int i=0;i<arr.length;++i){
            int x = toInteger(arr[i]);
            if(x==-1)   continue;
            int xReverse = 0;
            for(int j=3;j>=0;--j){
                if((1&(x>>j))==1){
                    xReverse |= (1<<(3-j));
                }
            }
            arr[i] = toHex(xReverse);
        }
        return String.valueOf(arr);
    }
    private static int toInteger(char c){
        if(c-'0'>=0 && c-'9'<=0){
            return c-'0';
        }else if(c-'a'>=0 && c-'f'<=0){
            return 10+c-'a';
        }else if(c-'A'>=0 && c-'F'<=0){
            return 10+c-'A';
        }
        return  -1;
    }
    private static char toHex(int a){
        if(a>=0 && a<=9){
            return (char)('0'+a);
        }else if(a>=10 && a<=15){
            return (char)('A'+a-10);
        }
        return (char)('A'+a-10);
    }
}
