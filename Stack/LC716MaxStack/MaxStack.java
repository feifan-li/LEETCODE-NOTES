package Stack.LC716MaxStack;

import java.util.TreeMap;
import java.util.TreeSet;

class MaxStack {
    public TreeSet<int[]> sorted;
    public TreeMap<Integer,Integer> stack;
    public int cnt = 0;
    public MaxStack() {
        this.stack = new TreeMap<>();
        this.sorted = new TreeSet<>((a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
    }

    public void push(int x) {
        stack.put(cnt,x);
        sorted.add(new int[]{x,cnt});
        cnt++;
    }

    public int pop() {
        sorted.remove(new int[]{stack.get(stack.lastKey()),stack.lastKey()});
        return stack.remove(stack.lastKey());
    }

    public int top() {
        return stack.get(stack.lastKey());
    }

    public int peekMax() {
        return sorted.last()[0];
    }

    public int popMax() {
        int[] x = sorted.pollLast();
        stack.remove(x[1]);
        return x[0];
    }
}
