package CompanyQuestions.HuaweiJishi.HJ62查找输入整数二进制中1的个数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(in.hasNext()){
            list.add(in.nextInt());
        }
        for(int i=0;i<list.size();++i){
            System.out.println(count(list.get(i)));
        }
    }
    private static int count(int num){
        int ans = 0;
        for(int i=0;i<32;++i){
            if((1&(num>>i))==1){
                ans++;
            }
        }
        return ans;
    }
}
