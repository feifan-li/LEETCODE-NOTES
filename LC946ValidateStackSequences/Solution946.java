package LC946ValidateStackSequences;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0, j = 0;
        int[] stack = new int[n];
        int top = -1;
        while(i<n && j<n){
            if(top!=-1 && stack[top]==popped[j]){//peek
                top--;
                j++;
            }else{
                stack[++top] = pushed[i++];//push
            }
        }
        while(top!=-1){
            if(stack[top--]!=popped[j++])    return false;//pop
        }
        return true;
    }
}
