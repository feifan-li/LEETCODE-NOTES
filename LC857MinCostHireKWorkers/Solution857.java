package LC857MinCostHireKWorkers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution857 {
    static class Employee{
        public int quality;
        public double rubbishDegree;
        public Employee(int quality,int wage){
            this.quality = quality;
            this.rubbishDegree = (double) wage/ (double)quality;
        }
    }
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Employee[] incEmployee = new Employee[quality.length];
        for(int i=0;i< quality.length;++i){
            incEmployee[i] = new Employee(quality[i],wage[i]);
        }
        Arrays.sort(incEmployee,(a,b) -> a.rubbishDegree <= b.rubbishDegree ? -1 : 1);
        PriorityQueue<Integer> maxQuality = new PriorityQueue<Integer>((a,b) -> b-a);
        double minCost = Double.MAX_VALUE;
        for(int i=0,qualitySum=0;i<quality.length;++i){
            int curQuality = incEmployee[i].quality;
            if(maxQuality.size()<k){
                qualitySum+=curQuality;
                maxQuality.add(curQuality);
                if(maxQuality.size()==k){
                    minCost = Math.min(minCost,qualitySum*incEmployee[i].rubbishDegree); // must meet all worker's expectation
                }
            }else{
                if(curQuality<maxQuality.peek()){
                    qualitySum = qualitySum - maxQuality.poll()+curQuality;
                    maxQuality.add(curQuality);
                }
                minCost = Math.min(minCost,qualitySum*incEmployee[i].rubbishDegree);
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30},2));
        System.out.println(mincostToHireWorkers(new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7},3));

    }
}
