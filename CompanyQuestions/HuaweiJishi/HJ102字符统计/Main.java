package CompanyQuestions.HuaweiJishi.HJ102字符统计;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[][] map = new int[100][2];
        for(int i=0;i<100;++i){
            map[i][0] = i;
        }
        for(int i=0;i<s.length();++i){
            map[s.charAt(i)-'0'][1] += 1;
        }
        Arrays.sort(map,(a, b)->(b[1]==a[1]?a[0]-b[0]:b[1]-a[1]));
        for(int i=0;i<100;++i){
            if(map[i][1]!=0)    System.out.print((char)(map[i][0]+'0'));
            else break;
        }
        System.out.println();
    }
}
