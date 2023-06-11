package OODesign.LC1146SnapshotArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution1146 {
    class SnapshotArray {
        public ArrayList<ArrayList<Integer>> log;
        //记录index处在哪些snapId期间被修改了
        public int snapId;
        public HashMap<Integer, HashMap<Integer,Integer>> map;
        //当前snapId仅记录上一个snapId期间所有val被更改的index
        public SnapshotArray(int length) {
            log = new ArrayList<>();
            for(int i=0;i<length;++i)   log.add(new ArrayList<Integer>());
            snapId = -1;
            map = new HashMap<>();
        }

        public void set(int index, int val) {
            if(!map.containsKey(snapId+1)){
                map.put(snapId+1,new HashMap<Integer,Integer>());
            }
            map.get(snapId+1).put(index,val);
            log.get(index).add(snapId);
        }

        public int snap() {
            snapId++;
            if(!map.containsKey(snapId))    map.put(snapId,new HashMap<Integer,Integer>());
            return snapId;
        }

        public int get(int index, int snap_id) {
            if(map.get(snap_id).containsKey(index)){//当前snapId记录了上一个snapId对index处的更改
                return map.get(snap_id).get(index);
            }
            int modifiedDuringSnapId = binarySearchMaxElementSmallerThan(log.get(index),snap_id-1);
            if(modifiedDuringSnapId>=-1){
                return map.get(modifiedDuringSnapId+1).get(index);
            }
            return 0;//snapId之前的所有版本都未曾对index处的值进行过更改
        }

        public int binarySearchMaxElementSmallerThan(ArrayList<Integer> nums,int target){
            int left = 0, right = nums.size()-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(nums.get(mid)>=target)    right = mid-1;
                else    left = mid+1;
            }
            return right<0?-2:nums.get(right);
        }
    }

    public static void main(String[] args) {

    }
}
