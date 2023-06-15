package DivideAndConquer.LC255VerifyPreorderSequenceInBST;

import java.util.Stack;

public class Solution255_2 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<preorder.length;++i){
            if(preorder[i]<root)    return false;
            while(!s.isEmpty() && preorder[i]>s.peek()) root = s.pop();
            s.push(preorder[i]);
        }
        return true;
    }
}
