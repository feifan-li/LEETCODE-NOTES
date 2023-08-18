package OODesign.LC379DesignPhoneDirectory;

import java.util.TreeSet;

class PhoneDirectory {
    public TreeSet<Integer> assigned;
    public TreeSet<Integer> free;
    public PhoneDirectory(int maxNumbers) {
        assigned = new TreeSet<>();
        free = new TreeSet<>();
        for(int i=0;i<maxNumbers;++i)  free.add(i);
    }

    public int get() {
        if(free.isEmpty())  return -1;
        int res = free.pollFirst();
        assigned.add(res);
        return res;
    }

    public boolean check(int number) {
        return free.contains(number);
    }

    public void release(int number) {
        if(assigned.contains(number)){
            assigned.remove(number);
            free.add(number);
        }
    }
}
