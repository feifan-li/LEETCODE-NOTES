package QuickSort_Application.LC973KClosestPointsToOrigin;

public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] dist = new int[points.length][2];
        for(int i=0;i<points.length;++i){
            dist[i][0] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            dist[i][1] = i;
        }
        quickSort(dist,0,dist.length-1,k);
        int[][] ans = new int[k][2];
        for(int i=0;i<k;++i){
            ans[i][0] = points[dist[i][1]][0];
            ans[i][1] = points[dist[i][1]][1];
        }
        return ans;
    }
    public void quickSort(int[][] dist,int L,int R,int k){
        if(L>=R)    return;
        swap(dist,L+(int)(Math.random()*(R-L+1)),R);
        int[] equal = partition(dist,L,R);
        quickSort(dist,L,equal[0]-1,k);
        if(k>equal[1])  quickSort(dist,equal[1]+1,R,k);
    }
    public int[] partition(int[][] dist,int L,int R){
        int lessR = L-1, moreL = R, i = L;
        while(i<moreL){
            if(dist[i][0]<dist[R][0])   swap(dist,++lessR,i++);
            else if(dist[i][0]>dist[R][0])  swap(dist,--moreL,i);
            else i++;
        }
        swap(dist,moreL,R);
        return new int[]{lessR+1,moreL};
    }
    public void swap(int[][] dist,int i,int j){
        int x = dist[i][0];
        dist[i][0] = dist[j][0];
        dist[j][0] = x;
        int y = dist[i][1];
        dist[i][1] = dist[j][1];
        dist[j][1] = y;
    }
}
