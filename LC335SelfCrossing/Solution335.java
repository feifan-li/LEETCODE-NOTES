package LC335SelfCrossing;

public class Solution335 {
    public boolean isSelfCrossing(int[] d) {
        for(int i=3;i<d.length;++i){
            //cross "vertically"
            if(d[i-1]<=d[i-3] && d[i]>=d[i-2])  return true;
                //cross with same direction "overlaply"
            else if(i>=4 && d[i-1]==d[i-3] && d[i]+d[i-4]>=d[i-2])    return true;
                //cross "vertically"
            else if(i>=5 && d[i]+d[i-4]>=d[i-2] && d[i-2]>=d[i-4]
                    && d[i-1]+d[i-5]>=d[i-3] && d[i-1]<=d[i-3])   return true;
        }
        return false;
    }
}
/**
                                                * * * * *
                                                *       *
    * * *               * * * *             * *{*}* *   *
    *   *               *     *             *   *  (*)  *
    * *{*}* *           *   {(*)}           *   *       *
        *               *     *             *           *
       (*)              * * * *             * * * * * * *
 */
