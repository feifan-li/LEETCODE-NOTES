package LC881BoatsToSavePeople;

import java.util.Arrays;

public class Solution881 {
    // people[i] <= limit
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);//排序后 保证每次选取的 符合规定的 人的重量和Limit的差距最小
        int ans = 0;
        int l = 0, r = people.length-1;
        int cur = 0;//当前搭载的重量
        while(l <= r){
            cur = l==r ? people[l] : people[l]+people[r];//每次先看未搭载的人中，最轻的和最重的在一起能不能超重
            if(cur>limit){//若超重，只搭载r位置的people（两者最重的）, 因为单个people不会超重
                r--;
            }else{//这两个人不超重，则搭载这两个人
                l++;
                r--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2},3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1},3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4},5));
    }
}
