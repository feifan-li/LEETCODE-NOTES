package LC427ConstructQuadTree;

public class Solution427 {
    // Definition for a QuadTree node.
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", isLeaf=" + isLeaf +
                    ", topLeft=" + topLeft +
                    ", topRight=" + topRight +
                    ", bottomLeft=" + bottomLeft +
                    ", bottomRight=" + bottomRight +
                    '}';
        }
    };

    private static boolean allSameValue(boolean x1,boolean x2,boolean x3,boolean x4){
        short x = x1?(short)1:(short)0;
        if(x2) x |= 2;
        if(x3) x |= 4;
        if(x4) x |= 8;
        return (x==15||x==0);
    }
    public static Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid,0,n-1,0,n-1);
    }
    private static Node helper(int[][] grid,int rowStart,int rowEnd,int colStart,int colEnd){
        if(colStart==colEnd && rowStart==rowEnd){
            return new Node(grid[rowStart][colStart]==1?true:false,true);
        }
        //all same value -> isLeaf = true, val = the value, four child=null
        //diff value -> isLeaf = false, val = true/false, four child
        Node tl = helper(grid,rowStart,(rowStart+rowEnd)/2,colStart,(colStart+colEnd)/2);
        Node tr = helper(grid,rowStart,(rowStart+rowEnd)/2,(colStart+colEnd)/2+1,colEnd);
        Node bl = helper(grid,(rowStart+rowEnd)/2+1,rowEnd,colStart,(colStart+colEnd)/2);
        Node br = helper(grid,(rowStart+rowEnd)/2+1,rowEnd,(colStart+colEnd)/2+1,colEnd);

        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && allSameValue(tl.val,tr.val,bl.val,br.val)){
            return new Node(tl.val,true);
        }
        return new Node(false,false,tl,tr,bl,br);
    }
    public static void main(String[] args) {
//        System.out.println(construct(new int[][]{{0,1},{1,0}}));
        construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
//        construct(new int[][]{{1,1,1,1},{1,1,1,1},{0,0,0,0},{0,0,0,0},});
//        System.out.println(construct(new int[][]{{0,0},{0,0}}));
    }
}
