package CompanyQuestions.HuaweiJishi.DP.最长递增子序列.HJ24合唱队;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] heights = new int[N];
        for(int i=0;i<N;++i){
            heights[i] = in.nextInt();
        }
        int[] lis = new int[N];
        lis[0] = 1;
        for(int i=1;i<N;++i){
            for(int j=0;j<i;++j){
                if(heights[i]>heights[j])   lis[i] = Math.max(lis[i],lis[j]+1);
                else    lis[i] = Math.max(1,lis[i]);
            }
        }
        int[] lds = new int[N];
        lds[N-1] = 1;
        for(int i = N-2;i>=0;--i){
            for(int j = N-1;j>i;--j){
                if(heights[i]>heights[j])   lds[i] = Math.max(lds[i],lds[j]+1);
                else    lds[i] = Math.max(1,lds[i]);
            }
        }
        int remain = Integer.MIN_VALUE;
        for(int i=0;i<N;++i){
            remain = Math.max(remain,lis[i]+lds[i]-1);
        }
        System.out.println(N-remain);
    }
}
