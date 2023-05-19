package CompanyQuestions.HJ.HJ5_进制转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String hex = in.nextLine();
            int pow16 = 1;
            int dec = 0;
            for(int i=hex.length()-1;i>=2;--i){
                dec += convert(hex.charAt(i))*pow16;
                pow16 = pow16*16;
            }
            System.out.println(dec);
        }
    }
    private static int convert(char c){
        if(c-'0'>=0 && c-'9'<=0){
            return (c-'0');
        }
        int ans = 10+(c-'A');
        return ans;
    }
}
