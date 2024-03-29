package OODesign.LC460LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
    public int cap;
    public int minFreq;
    HashMap<Integer,Integer> keyToVal;
    HashMap<Integer,Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if(!keyToVal.containsKey(key)) return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(this.cap<=0) return;
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increaseFreq(key);
            return;
        }
        if(this.cap<=keyToVal.size()) removeMinFreqKey();
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }
    private void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freqToKeys.get(freq).remove(key);
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if(freq == this.minFreq) this.minFreq++;
        }
        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
    }
    private void removeMinFreqKey(){
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if(keyList.isEmpty())   freqToKeys.remove(this.minFreq);
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}