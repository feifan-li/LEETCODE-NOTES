package Greedy.LC277FindTheCelebrity;

public class Solution277 {
    public int findCelebrity(int n) {
        int p = 0;
        for(int i=1;i<n;++i){
            if(knows(p,i))  p = i;
        }
        //if celebrity exists, since everybody knows p, p will always be set to celebrity by one person smaller, then since p know nobody, p is eventually the celebrity(celebrity can't' reach "p=i")
        //otherwise, p should at least know one person other than himself, or at least one person should not know p
        for(int i=0;i<n && i!=p;++i){
            if(knows(p,i) || !knows(i,p)) return -1;
        }
        return p;
    }
    public boolean knows(int a, int b)  {return true;}//true or false
}
