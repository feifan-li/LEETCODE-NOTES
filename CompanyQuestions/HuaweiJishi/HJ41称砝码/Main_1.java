package CompanyQuestions.HuaweiJishi.HJ41称砝码;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        int[] cnt = new int[n];
        for(int i=0;i<n;++i){
            weight[i] = in.nextInt();
            assert weight[i]>=1;
        }
        for(int i=0;i<n;++i){
            cnt[i] = in.nextInt();
            assert cnt[i]>=1;
        }
        HashSet<Integer> set = new HashSet<>();//set of weights
        set.add(0);
        for(int i=0;i<n;++i){
            ArrayList<Integer> list = new ArrayList<>(set);
            for(int j=1;j<=cnt[i];++j){
                for(int curWeight:list){
                    set.add(curWeight+weight[i]*j);
                }
            }
        }
        System.out.println(set.size());
    }

}
