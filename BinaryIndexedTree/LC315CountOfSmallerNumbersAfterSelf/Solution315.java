package BinaryIndexedTree.LC315CountOfSmallerNumbersAfterSelf;

import java.util.*;

public class Solution315 {
    public static int[] tree;//动态管理a中元素在nums中的频次
    //discretization nums:
    public static int[] a;
//    public int[] freq; 可以但不需要显式地维护频次数组，因为频次、频次数组的前缀和随时在变，使用树状数组足矣
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res= new ArrayList<>();
        discretization(nums);
        tree = new int[a.length+1];
        //从后向前遍历，动态地维护前缀和，因为每个元素只关注自己右侧的情况
        for(int i=nums.length-1;i>=0;--i){
            int id = getId(nums[i]);
            res.add(sum(id-1));
            update(id,1);//freq of a[id] +1
        }
        Collections.reverse(res);
        return res;
    }
    public static int lowbit(int i){
        return (-i)&i;
    }
    public static int sum(int i){//前缀和
        int ans = 0;
        for(;i>0;i-=lowbit(i)) ans += tree[i];
        return ans;
    }
    public static void update(int i,int z){//点更新
        for(;i<tree.length;i+=lowbit(i)){
            tree[i] += z;
        }
    }
    public static void discretization(int[] nums){//离散化
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        a = new int[set.size()];
        int index = 0;
        for(int num:set) a[index++] = num;
        Arrays.sort(a);
    }
    public static int getId(int x){//id starts from 1
        return Arrays.binarySearch(a,x)+1;
    }

    public static void main(String[] args) {
//        System.out.println(countSmaller(new int[]{5,2,6,1}));
//        System.out.println(countSmaller(new int[]{0}));
        System.out.println(countSmaller(new int[]{0,0}));
    }
}
