package JavaBasics.LC170TwoSumIII_DataStructureDesign;

import java.util.HashMap;

public class TwoSum {
    private int[] nums;
    private int top;
    private HashMap<Integer,Integer> map;//number->freq
    public TwoSum() {
        nums = new int[10000];
        top = -1;
        map = new HashMap<>();
    }

    public void add(int number) {
        nums[++top] = number;
        map.put(number,map.getOrDefault(number,0)+1);
    }

    public boolean find(int value) {
        /**Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false. **/
        for(int i=0;i<=top;++i){
            if(value-nums[i]!=nums[i] && map.containsKey(value-nums[i])){
                return true;
            }else if(value-nums[i]==nums[i] && map.containsKey(nums[i]) && map.get(nums[i])>1){
                return true;
            }
        }
        return false;
    }
}
