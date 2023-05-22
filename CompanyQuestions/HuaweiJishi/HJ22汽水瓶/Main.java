package CompanyQuestions.HuaweiJishi.HJ22汽水瓶;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num>0){
                nums.add(num);
            }else{
                break;
            }
        }
        for(int i=0;i<nums.size();++i){
            int empty = nums.get(i);
            int ans = 0;
            while(empty>=3){
                ans += empty/3;
                empty = empty/3 + empty%3;
            }
            if(empty==2)    ans++;
            System.out.println(ans);
        }
    }
}
