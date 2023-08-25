package LC391PerfectRectangle;

import java.util.HashSet;

public class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        HashSet<String> vertices = new HashSet<>();
        int area = 0, x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        for(int[] rect:rectangles){
            area += (rect[2]-rect[0])*(rect[3]-rect[1]);
            x = Math.min(x,rect[0]);
            y = Math.min(y,rect[1]);
            a = Math.max(a,rect[2]);
            b = Math.max(b,rect[3]);
            String bl = rect[0]+","+rect[1];
            String tr = rect[2]+","+rect[3];
            String tl = rect[0]+","+rect[3];
            String br = rect[2]+","+rect[1];
            if(!vertices.add(bl))    vertices.remove(bl);
            if(!vertices.add(tr))    vertices.remove(tr);
            if(!vertices.add(tl))    vertices.remove(tl);
            if(!vertices.add(br))    vertices.remove(br);
        }
        return vertices.size()==4 && area==(a-x)*(b-y) && vertices.contains(x+","+y) && vertices.contains(a+","+b)
                && vertices.contains(x+","+b) && vertices.contains(a+","+y);
    }
}
