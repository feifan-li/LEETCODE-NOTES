package OODesign.LC1396DesignUndergroundSystem;
import java.util.HashMap;
public class UndergroundSystem {
    public class Pair{
        private String key;
        private Integer value;
        public Pair(String k,Integer v){
            key = k;
            value = v;
        }
    }
    public HashMap<Integer, Pair> inMap;//stationName,timestamp
    public HashMap<String,long[]> routeMap;//route -> [headCount,totalTime]
    public UndergroundSystem() {
        inMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        inMap.put(id,new Pair(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        String checkInStation = inMap.get(id).key;
        String route = checkInStation+"->"+stationName;
        int checkInTime = inMap.get(id).value;
        int duration = t - checkInTime;
        if(!routeMap.containsKey(route)){
            routeMap.put(route,new long[]{0L,0L});
        }
        long[] stat = routeMap.get(route);
        routeMap.put(route,new long[]{stat[0]+1,stat[1]+duration});
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" +endStation;
        long[] stat = routeMap.get(route);
        return (double)stat[1]/(double)stat[0];
    }
}
