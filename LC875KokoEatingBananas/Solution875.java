package LC875KokoEatingBananas;

public class Solution875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles) +1;
        while(left<right){
            int speed = left + (right-left)/2;
            if(canFinishWithin(piles,speed,h)){
                right = speed;
            }else{
                left = speed+1;
            }
        }
        return left;
    }
    public static boolean canFinishWithin(int[] piles, int speed, int H){
        int hours = 0;
        for(int num:piles){
            hours += Math.ceil((double)num/speed);
        }
        return hours <= H;
    }
    public static int getMax(int[] p){
        int max = 0;
        for(int num:p){
            max = Math.max(max,num);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] piles1 = new int[]{3,6,7,11};
        int[] piles2 = new int[]{30,11,23,4,20};
        int h1 = 8;
        int h2 = 5;
        int h3 = 6;
        System.out.println(minEatingSpeed(piles1,h1));
        System.out.println(minEatingSpeed(piles2,h2));
        System.out.println(minEatingSpeed(piles2,h3));

    }
}
