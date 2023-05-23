package CompanyQuestions.HuaweiJishi.JavaBasics.HJ35蛇形矩阵;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<N;++i){
            ans.add(new ArrayList<Integer>());
        }
        int num = 1;
        for(int round = 0;round<N;++round){
            for(int i=round;i>=0;--i){
                ans.get(i).add(num);
                ++num;
            }
        }
        for(int i=0;i<N;++i){
            for(int j=0;j<ans.get(i).size();++j){
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
