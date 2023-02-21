package BinarySearch.LC1539KthMissingPositiveNumber;
//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//Return the kth positive integer that is missing from this array.
public class Solution1539_OPT {
    //二分法
    public static int findKthPositive(int[] arr, int k) {
        int l=0,r=arr.length-1;
        int find = arr.length;
        //find值是下标值 arr[i]-(i+1)>=k find是最小的满足该关系的下标i
        //所以while二分结束后 find-1 是最大的满足arr[j]-(j+1)<k的下标j, arr[find-1]=preValue
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]-(mid+1)>=k){ //下标mid处对应的值在不缺失时应该为mid+1 实际为arr[mid] 所以缺失了arr[mid]-(mid+1)个正整数
                find = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println("find = "+find);
        int preValue = find==0 ? 0 : arr[find-1];
        System.out.println("preValue = "+preValue);
        int under = preValue-find; //1 ~ preValue缺了under个正整数 即under = arr[find-1]-(find-1+1) = preValue - find
        System.out.println("under = "+under);
        return preValue+(k-under);//1 ~ preValue缺了under个正整数， 在preValue的基础上依次补上k-under个
    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{100,101,102,103,104,105},99));
        System.out.println("_________________");
        System.out.println(findKthPositive(new int[]{1,2,3,4,5},10));
    }
}
