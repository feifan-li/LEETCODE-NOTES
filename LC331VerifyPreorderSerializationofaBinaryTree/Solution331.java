package LC331VerifyPreorderSerializationofaBinaryTree;

public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        int emptySlots = 1;
        for(String node:preorder.split(",")){
            if(--emptySlots<0)   return false;//null or non-null node takes up one slot
            if(!node.equals("#"))   emptySlots += 2;//non-null node create two slots for its left child and right child
        }
        return emptySlots==0;//no slots be left
    }
}
