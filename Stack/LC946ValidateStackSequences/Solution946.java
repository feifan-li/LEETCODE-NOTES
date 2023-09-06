package Stack.LC946ValidateStackSequences;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int[] stack = new int[n];
        int i = 0, j = 0, top = -1;
        while(i<n && j<n){
            if(top==-1 || stack[top]!=popped[j]){
                if(i>=n)    return false;
                stack[++top] = pushed[i++];
            }else{
                top--;
                j++;
            }
        }
        while(j<n){
            if(top==-1 || stack[top--]!=popped[j++])    return false;
        }
        return true;
    }
}
