package CompanyQuestions.HuaweiJishi.JavaBasics.HJ80整型数组合并;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<m;++i){
            set.add(in.nextInt());
        }
        int n = in.nextInt();
        for(int i=0;i<n;++i){
            set.add(in.nextInt());
        }
        ArrayList<Integer> ans = new ArrayList<>(set);
        for(int i=0;i<ans.size();++i){
            System.out.print(ans.get(i));
        }
        System.out.println();
    }
}
