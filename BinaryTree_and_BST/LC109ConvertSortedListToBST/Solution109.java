package BinaryTree_and_BST.LC109ConvertSortedListToBST;

public class Solution109 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }
    //Divide and Conquer
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode beforeSlow = null;
        ListNode slow = head;//the root of tree
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        beforeSlow.next = null;
        return new TreeNode(slow.val,sortedListToBST(head),sortedListToBST(slow.next));
    }
}
