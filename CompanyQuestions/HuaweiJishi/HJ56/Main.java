package CompanyQuestions.HuaweiJishi.HJ56;

import java.util.Scanner;

public class Main {
    /**完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。

     它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。

     例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。

     输入n，请输出n以内(含n)完全数的个数。

     数据范围：1≤n≤5×10^5
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        int ans = 0;
        for(long i=33550336;i<=n;++i){
            long sum = 1;
            for(long factor=2;factor*factor<=i;++factor){
                if(i%factor==0) sum+=(factor+(i/factor));
                if(factor*factor==i)    sum -= factor;
            }
            if(sum==i)  {
                ans ++;
                System.out.print(i+" ");
            }
        }
        System.out.println(ans);
    }
    /**完全数：
     * 6 28 496 8128 33550336 ...
     * **/
}
