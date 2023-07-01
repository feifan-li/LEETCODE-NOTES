package Backtrack.LC2305FairDistributionOfCookies;

public class Solution2305 {
    public int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        if(k==cookies.length){
            int max=0;
            for(int cookie:cookies) max = Math.max(max,cookie);
            return max;
        }
        backtrack(cookies,new int[k],0,0);
        return res;
    }
    public void backtrack(int[] cookies,int[] children, int index,int max){
        //each cookie has k choices
        if(index>=cookies.length){
            res = Math.min(res,max);
            return;
        }
        for(int i=0;i<children.length;++i){
            children[i] += cookies[index];
            backtrack(cookies,children,index+1,Math.max(max,children[i]));
            children[i] -= cookies[index];
        }
    }
}
