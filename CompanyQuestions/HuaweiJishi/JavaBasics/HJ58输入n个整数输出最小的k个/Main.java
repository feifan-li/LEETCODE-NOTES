package CompanyQuestions.HuaweiJishi.JavaBasics.HJ58输入n个整数输出最小的k个;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int cnt = 0;cnt<n;++cnt){
            q.add(in.nextInt());
        }
        for(int cnt=0;cnt<k;++cnt){
            System.out.print(q.poll()+" ");
        }
    }
}
