package DynamicProgramming.LC837New21Game;

public class Solution837 {
    public double new21Game(int n, int k, int maxPts) {
        double[] p = new double[n+1];
        p[0] = 1.0;
        if(n==0)    return 1.0;
        if(k==0)    return 1.0;
        double choices = p[0];
        for(int i=1;i<=n;++i){
            p[i] = choices/maxPts;
            if(i<k) choices += p[i];
            if(i-maxPts>=0 && i-maxPts<k)   choices -= p[i-maxPts];
        }
        double ans = 0;
        for(int i=k;i<=n;++i)   ans += p[i];
        return ans;
    }
}
