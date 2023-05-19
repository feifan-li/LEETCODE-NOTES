package CompanyQuestions.HJ.HJ3;

import java.util.Scanner;
import java.util.TreeSet;

public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int N = in.nextInt();
        for(int cnt=0;cnt<N;++cnt){
            set.add(in.nextInt());
        }
        while(!set.isEmpty()){
            System.out.println(set.first());
            set.pollFirst();
        }
    }
}
