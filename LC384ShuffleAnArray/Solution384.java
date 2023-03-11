package LC384ShuffleAnArray;

public class Solution384 {
    public int[] origin;
    public Solution384(int[] nums) {
        origin = nums;
    }
    public int[] reset() {
        return origin;
    }
    public int[] shuffle() {
        int n = origin.length;
        int[] ans = this.origin.clone();
        for(int i=n-1;i>=0;--i){
            int index = (int)(Math.random()*n);//[0,n-1]
            swap(ans,index,n-1);
            n--;
        }
        return ans;
    }
    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
