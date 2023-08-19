package OODesign.LC381InsertDeleteGetRandomO1_DuplicatesAllowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

public class RandomizedCollection {
    public HashMap<Integer, TreeSet<Integer>> valToIdList;
    public ArrayList<Integer> valList;
    public Random r;
    public RandomizedCollection() {
        valToIdList = new HashMap<>();
        valList = new ArrayList<>();
        r = new Random();
    }
    public boolean insert(int val) {
        boolean presentBeforeInsert = valToIdList.containsKey(val);
        valList.add(val);
        if(!presentBeforeInsert)    valToIdList.put(val,new TreeSet<>());
        valToIdList.get(val).add(valList.size()-1);
        return !presentBeforeInsert;
    }
    public boolean remove(int val) {
        if(!valToIdList.containsKey(val))   return false;
        int freeIndex = valToIdList.get(val).pollFirst();
        if(valToIdList.get(val).isEmpty())  valToIdList.remove(val);
        if(freeIndex==valList.size()-1){
            valList.remove(valList.size()-1);
            return true;
        }
        int lastVal = valList.remove(valList.size()-1);
        valList.set(freeIndex,lastVal);
        valToIdList.get(lastVal).remove(valList.size());//remove value from the TreeSet
        valToIdList.get(lastVal).add(freeIndex);
        return true;
    }
    public int getRandom() {
        return valList.get(r.nextInt(valList.size()));
    }
}
