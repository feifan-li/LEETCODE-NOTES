package MonotonicStack.LC155MinStack;

public class Solution155 {
    class MinStack {
        private int[] stack;
        private int top;
        private int[] monoStack;//decreasing from bottom to up
        private int topMono;
        public MinStack() {
            stack = new int[30000];
            top = -1;
            monoStack = new int[30000];
            topMono = -1;
        }

        public void push(int val) {
            stack[++top] = val;
            if(topMono==-1 || val<=monoStack[topMono]){
                monoStack[++topMono] = val;
            }
        }

        public void pop() {
            if(monoStack[topMono]==stack[top--]){
                topMono--;
            }
        }

        public int top() {
            return stack[top];
        }

        public int getMin() {
            return monoStack[topMono];
        }
    }
}
