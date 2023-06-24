package OODesign.LC281ZigZagIterator;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    public int v1_head = 0;
    public int v2_head = 0;
    public List<Integer> v1;
    public List<Integer> v2;
    public int next_query_id = 1;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = new ArrayList<Integer>(v1);
        this.v2 = new ArrayList<Integer>(v2);
    }

    public int next() {
        if(hasNext()){
            if(next_query_id==1){
                next_query_id = 2;
                return v1.get(v1_head++);
            }else if(next_query_id==2){
                next_query_id = 1;
                return v2.get(v2_head++);
            }
        }
        return -1;
    }

    public boolean hasNext() {
        if(next_query_id==1){
            if(v1_head<v1.size())   return true;
            else{
                next_query_id = 2;
                return v2_head<v2.size();
            }
        }else if(next_query_id==2){
            if(v2_head<v2.size())   return true;
            else{
                next_query_id = 1;
                return v1_head<v1.size();
            }
        }
        return false;
    }
}
