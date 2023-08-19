package OODesign.LC380InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    public HashMap<Integer,Integer> valueToId;
    public ArrayList<Integer> valList;
    public Random r;
    public RandomizedSet() {
        valueToId = new HashMap<>();
        valList = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if(valueToId.containsKey(val))  return false;
        valList.add(val);
        valueToId.put(val,valList.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(!valueToId.containsKey(val)) return false;
        int freeIndex = valueToId.remove(val);
        if(freeIndex==valList.size()-1){
            valList.remove(valList.size()-1);
            return true;
        }
        int lastVal = valList.remove(valList.size()-1);
        valList.set(freeIndex,lastVal);
        valueToId.put(lastVal,freeIndex);
        return true;
    }

    public int getRandom() {
        /**This is a read operation */
        return valList.get(r.nextInt(valList.size()));
    }
}
