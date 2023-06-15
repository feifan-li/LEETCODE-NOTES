package DivideAndConquer.LC255VerifyPreorderSequenceInBST;

public class Solution255 {
    public boolean verifyPreorder(int[] preorder) {
        //root,left child tree's preorder,right child tree's preorder
        //root.val,a continuous region < root.val,a continuous region > root.val
        return helper(preorder,0,preorder.length-1);
    }
    private boolean helper(int[] preorder,int start,int end){
        if(start==end)  return true;
        int firstBiggerId = -1;
        int lastSmallerId = -1;
        for(int i=start+1;i<=end;++i){
            if(preorder[i]>preorder[start]){
                firstBiggerId = i;
                break;
            }
        }
        for(int i=end;i>start;--i){
            if(preorder[i]<preorder[start]){
                lastSmallerId = i;
                break;
            }
        }
        if(firstBiggerId!=-1 && lastSmallerId!=-1 && lastSmallerId>firstBiggerId){
            return false;
        }else if(firstBiggerId==-1 && lastSmallerId==-1){
            return true;
        }else if(firstBiggerId==-1 || lastSmallerId==-1){
            return helper(preorder,start+1,end);
        }else{
            return helper(preorder,start+1,lastSmallerId) && helper(preorder,firstBiggerId,end);
        }
    }
}
