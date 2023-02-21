package CompanyQuestions;

import java.util.Arrays;

// 来自hulu
// 有一个以原点为圆心，半径为1的圆
// 在这个圆的圆周上，有一些点
// 因为所有的点都在圆周上，所以每个点可以有很简练的表达
// 比如：用0来表示一个圆周上的点，这个点就在(1,0)位置
// 比如：用6000来表示一个点，这个点是(1,0)点沿着圆周逆时针转60.00度之后所在的位置
// 比如：用18034来表示一个点，这个点是(1,0)点沿着圆周逆时针转180.34度之后所在的位置
// 这样一来，所有的点都可以用[0, 36000)范围上的数字来表示
// 那么任意三个点都可以组成一个三角形，返回能组成钝角三角形的数量
public class obtuseAngles {
    public static long obtuseAngles(int[] arr){
        //扩容，排序
        int n = arr.length;
        int m = n<<1;
        int[] enlarge = new int[m];
        Arrays.sort(arr);
        for(int i=0;i<n;++i){
            enlarge[i] = arr[i];
            enlarge[i+n] = arr[i]+36000;
        }
        long ans = 0;
        //(r,r+180)内的所有点中任取两个点都可以与r构成钝角三角形
        //不回退的窗口
        for(int l=0,r=0;l<n;++l){
            while(r<m && enlarge[r]-enlarge[l] < 18000) {r++;}
            ans += c(r-l-1);
//            System.out.println(ans);
        }
        return ans;
    }
    private static long c(long n){
        return n<2 ? 0:(n*(n-1))>>1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3017,5735,10200,21036,31035,35047};
        System.out.println(obtuseAngles(arr));
    }
}
