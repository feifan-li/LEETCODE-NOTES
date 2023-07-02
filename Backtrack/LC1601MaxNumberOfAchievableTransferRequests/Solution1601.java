package Backtrack.LC1601MaxNumberOfAchievableTransferRequests;

public class Solution1601 {
    public int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] degrees = new int[n];
        for(int[] req:requests){
            degrees[req[0]]--;
            degrees[req[1]]++;
        }
        boolean all = true;
        for(int degree:degrees){
            if(degree!=0){
                all = false;
                break;
            }
        }
        if(all) return requests.length;
        backtrack(n,requests,new int[n],0,0);
        return max;
    }
    public void backtrack(int n,int[][] requests,int[] degrees,int index,int count){
        if(index==requests.length){
            for(int degree:degrees){
                if(degree!=0)   return;
            }
            max = Math.max(max,count);
            return;
        }
        if(requests[index][0]==requests[index][1]){
            backtrack(n,requests,degrees,index+1,count+1);
            return;
        }
        degrees[requests[index][0]]--;
        degrees[requests[index][1]]++;
        backtrack(n,requests,degrees,index+1,count+1);//choose requests[index]
        degrees[requests[index][0]]++;
        degrees[requests[index][1]]--;
        backtrack(n,requests,degrees,index+1,count);//not choose requests[index]
    }
}
