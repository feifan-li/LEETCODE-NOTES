package BinarySearch.LC1802MaxValueataGivenIndexInABoundedArray;

public class Solution1802 {
    public static int maxValue(int n, int index, int maxSum) {
        //每次对index处元素加一对sum的增量数列由以下三种子数列拼接而成：
        //第一部分：1，3，5，7，... ，2*min(index,n-index-1)+1， 通项为1+2*(n1-1) = 2*n1 -1, 解得该子数列共有min+1项，
        //该子数列的和为(min+1)^2
        //第二部分: 2*min(index,n-index-1)+2, 2*min(index,n-index-1)+3, ... , n， 共有n-2*min-1项
        //该子数列的和为(2*min+n+2)*(n-2*min-1)/2
        //第三部分: n,n,n,...
        long min = Math.min(index,n-index-1);
        long sum = maxSum - n;
        long n1 = -1, n2 = -1, n3 = -1;
        if((min+1)*(min+1)>=sum){
            n1 = (int)Math.sqrt(sum);
            return (int)(n1+1);
        }
        n1 = min+1;
        sum -= (min+1)*(min+1);
        if(((2*min+n+2)*(n-2*min-1)/2)>=sum){
            long left = 0,right = n-2*min-1;
            while(left<=right){
                long mid = left + (right-left)/2;
                if(((mid*mid)+mid*(4*min+3))==2*sum){
                    n2 = mid;
                    break;
                }
                if(((mid*mid)+mid*(4*min+3))<=2*sum && (((mid+1)*(mid+1))+(mid+1)*(4*min+3))>2*sum){
                    n2 = mid;
                    break;
                }else if(((mid*mid)+mid*(4*min+3)) < 2*sum){
                    left = mid+1;
                }else if(((mid*mid)+mid*(4*min+3)) >= 2*sum){
                    right = mid-1;
                }
            }
            n2 = n2==-1?right:n2;
            return (int)(n1+n2+1);
        }
        n2 = n-2*min-1;
        sum -= (2*min+n+2)*(n-2*min-1)/2;
        n3 = sum/n;
        return (int)(n1+n2+n3+1);
    }

    public static void main(String[] args) {
        System.out.println(maxValue(4116541,2948244,392357701));
    }
}
