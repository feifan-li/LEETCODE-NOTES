package SegmentTree;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,7,2,12,1,6,4,8,15};
        SegmentTree st = new SegmentTree(nums);
//        st.printTree();
        st.update(1,4,13);
        st.printTree();
        System.out.println(st.query1(1,5,9));
        System.out.println(st.query2(1,5,9));
        System.out.println(st.query1(1,1,10));
        System.out.println(st.query2(1,1,10));
        System.out.println(st.query1(1,2,4));
        System.out.println(st.query2(1,2,4));
    }
}
