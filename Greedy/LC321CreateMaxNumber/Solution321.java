package Greedy.LC321CreateMaxNumber;

public class Solution321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if(k==m+n)  return merge(nums1,nums2,k);
        int[] res = new int[k];
        for(int len=Math.max(0,k-n);len<=Math.min(k,m);++len){
            int[] temp = merge(lexicographicallyMaxArray(nums1,len),lexicographicallyMaxArray(nums2,k-len),k);
            if(lexicographicallyGreater(temp,0,res,0))  res = temp;
        }
        return res;
    }
    public int[] merge(int[] a,int[] b,int len){
        int[] res = new int[len];
        for(int i=0,j=0,r=0;r<len;++r){
            res[r] = lexicographicallyGreater(a,i,b,j)?a[i++]:b[j++];
        }
        return res;
    }
    public int[] lexicographicallyMaxArray(int[] a,int len){
        if(len==0)  return new int[0];
        else if(a.length==len)   return a;//since the relative order of the digits from the same array must be preserved.
        int[] res = new int[len];
        for(int i=0,j=0;i<a.length;++i){
            while(a.length-i>len-j && j>0 && a[i]>res[j-1])    j--;
            if(j<len)   res[j++] = a[i];
        }
        return res;
    }
    public boolean lexicographicallyGreater(int[] a,int i,int[] b,int j){
        //find first index where a[index]!=b[index]
        while(i<a.length && j<b.length && a[i]==b[j]){
            i++;
            j++;
        }
        if(i==a.length)         return false;
        else if(j==b.length)    return true;
        return a[i]>b[j];
    }
}
