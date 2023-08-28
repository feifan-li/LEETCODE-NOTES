package Stack.LC388LongestAbsoluteFilePath;

import java.util.Stack;

public class Solution388 {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(String s:input.split("\n")){
            int level = s.lastIndexOf("\t")+1;//stack此时只能有level个元素
            while(level<stack.size()) stack.pop();
            stack.push((stack.isEmpty()?0:stack.peek())+s.length()-level+1);//dir name or file name + "/"
            if(s.contains(".")) max = Math.max(max,stack.peek()-1);
        }
        return max;
    }
}
