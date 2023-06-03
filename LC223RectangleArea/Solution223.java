package LC223RectangleArea;

public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int Sa = (ax2-ax1)*(ay2-ay1);
        int Sb = (bx2-bx1)*(by2-by1);
        int Sab = rangeIntersect(ax1,ax2,bx1,bx2)*rangeIntersect(ay1,ay2,by1,by2);
        return Sa+Sb-Sab;
    }
    public int rangeIntersect(int a1, int a2, int b1, int b2){
        if(a1>=b1 && a1<=b2)   return Math.min(a2,b2) - a1;
        else if(b1>=a1 && b1<=a2)   return Math.min(a2,b2) - b1;
        return 0;
    }
}
