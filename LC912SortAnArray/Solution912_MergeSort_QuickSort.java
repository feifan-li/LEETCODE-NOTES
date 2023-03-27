package LC912SortAnArray;

import java.util.Stack;

public class Solution912_MergeSort_QuickSort {
    public class qsJob{
        int L;
        int R;
        public qsJob(int L,int R){
            this.L = L;
            this.R = R;
        }
    }
    public int[] sortArray(int[] nums) {
        if(nums.length<2) return nums;
        /** Merge Sort: BEST/AVERAGE/WORST CASE:O(NlogN)*/
        //mergeSort1(nums,0,nums.length-1);
        //mergeSort2(nums);
        /** Quick Sort: BEST/AVERAGE CASE:O(NlogN) WORST CASE:O(N^2)*/
        //quickSort(nums,0,nums.length-1);
        //quickSort2(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort1(int[] nums,int l,int r){
        //recursive mergeSort
        if(l==r) return;
        int mid = l + ((r-l)>>1);
        mergeSort1(nums,l,mid);
        mergeSort1(nums,mid+1,r);
        merge(nums,l,mid,r);
    }
    private void merge(int[] nums,int l,int mid,int r){
        int[] tmp = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int i=0;
        while(p1<=mid && p2<=r){
            tmp[i++] = nums[p1]<=nums[p2]? nums[p1++]:nums[p2++];
        }
        while(p1<=mid)  tmp[i++] = nums[p1++];
        while(p2<=r)    tmp[i++] = nums[p2++];
        for(i=l;i<=r;++i) nums[i] = tmp[i-l];
    }
    public void mergeSort2(int[] nums){
        //non-recursive mergeSort,also O(N*logN)
        int mergeSize = 1;//merge tow sorted array with size mergeSize ea
        int N = nums.length;
        while(mergeSize<N){
            int L = 0;
            while(L<N){
                int M = (N-L<=mergeSize)?N-1:L+mergeSize-1;
                if(M==N-1) break;
                int R = (N-1-M<=mergeSize)?N-1:M+mergeSize;
                merge(nums,L,M,R);
                if(R==N-1) break;
                L = R+1;
            }
            if(mergeSize>(N/2)) break;
            else mergeSize*=2;
        }
    }
    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private int[] partition(int[] arr,int L,int R){
        if(L==R) return new int[]{L,L};
        int lessR = L-1;
        int moreL = R;
        int index=L;
        while(index<moreL){
            if(arr[index]<arr[R]){
                swap(arr,++lessR,index++);
            }else if(arr[index]>arr[R]){
                swap(arr,--moreL,index);
            }else index++;
        }
        swap(arr,moreL,R);
        return new int[]{lessR+1,moreL};
    }
    public void quickSort(int[] arr,int L,int R){
        //recursive quick sort
        if(L>=R) return;
        swap(arr,L+(int)(Math.random()*(R-L+1)),R);
        int[] equalRange = partition(arr,L,R);
        quickSort(arr,L,equalRange[0]-1);
        quickSort(arr,equalRange[1]+1,R);
    }
    public void quickSort2(int[] arr,int L,int R){
        //non-recursive quick sort
        Stack<qsJob> stack = new Stack<>();
        stack.push(new qsJob(L,R));
        while(!stack.isEmpty()){
            qsJob cur = stack.pop();
            int[] equal = partition(arr,cur.L,cur.R);
            if(equal[0]>cur.L) stack.push(new qsJob(cur.L,equal[0]-1));
            if(equal[1]<cur.R) stack.push(new qsJob(equal[1]+1,cur.R));
        }
    }
}
