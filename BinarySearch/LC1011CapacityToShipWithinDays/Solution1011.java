package BinarySearch.LC1011CapacityToShipWithinDays;

import java.util.Arrays;
import java.util.Stack;

public class Solution1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum()+1;

        while(left<right){
            int capacity = left+(right-left)/2;
            if(canFinish(weights,capacity,days)){
                right = capacity;
            }else{
                left = capacity+1;
            }
        }
        return left;
    }
    public static boolean canFinish(int[] w,int capacity, int D){
        Stack<Integer> stack = new Stack<>();
        stack.push(w[0]);
        for(int i=1;i<w.length;++i){
            if(stack.peek()<=capacity && stack.peek()+w[i]>capacity){
                stack.push(w[i]);
                continue;
            }else if(stack.peek()<=capacity && stack.peek()+w[i]<=capacity){
                int tmp = stack.pop();
                stack.push(tmp+w[i]);
                continue;
            }
        }
        return stack.size()<=D;
    }

    public static void main(String[] args) {
        int[] weights1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        int[] weights2 = new int[]{3,2,2,4,1,4};
        int days2 = 3;
        int[] weights3 = new int[]{1,2,3,1,1};
        int days3 = 4;
        System.out.println(shipWithinDays(weights1,days1));
        System.out.println(shipWithinDays(weights2,days2));
        System.out.println(shipWithinDays(weights3,days3));

    }
}
