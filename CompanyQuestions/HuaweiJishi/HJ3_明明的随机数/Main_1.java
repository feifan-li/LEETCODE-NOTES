package CompanyQuestions.HuaweiJishi.HJ3_明明的随机数;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int[] map = new int[510];//index 0~500
        int N = in.nextInt();
        for(int cnt=0;cnt<N;++cnt){
            map[in.nextInt()] = 1;
        }
        for(int val = 1;val<map.length;++val){
            if(map[val] == 1){
                System.out.println(val);
            }else{
                continue;
            }
        }
    }
}
