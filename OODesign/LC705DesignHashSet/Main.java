package OODesign.LC705DesignHashSet;

import java.util.Arrays;

public class Main {
    class MyHashSet {
        int[] set;
        public MyHashSet() {
            set = new int[1000003];
            Arrays.fill(set,-1);
        }

        public void add(int key) {
            set[key] = 1;
        }

        public void remove(int key) {
            set[key] = -1;
        }

        public boolean contains(int key) {
            return (set[key]==1);
        }
    }
}
