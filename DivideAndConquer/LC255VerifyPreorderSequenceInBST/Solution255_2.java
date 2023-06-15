package DivideAndConquer.LC255VerifyPreorderSequenceInBST;

import java.util.Stack;

public class Solution255_2 {
    public boolean verifyPreorder(int[] preorder) {
        int[] s = new int[10001];
        int top = -1;
        int root = Integer.MIN_VALUE;
        for(int i=0;i<preorder.length;++i){
            if(preorder[i]<root)    return false;
            while(top!=-1 && preorder[i]>s[top]) root = s[top--];
            s[++top] = preorder[i];
        }
        return true;
    }
}
