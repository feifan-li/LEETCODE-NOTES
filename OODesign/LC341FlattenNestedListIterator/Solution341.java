package OODesign.LC341FlattenNestedListIterator;

import OODesign.LC339NestedListWeightSum.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution341 {
    public class NestedIterator implements Iterator<Integer> {

        public List<Integer> list;
        public int p;
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            p = -1;
            for(NestedInteger ni:nestedList)    helper(ni);
        }
        public void helper(NestedInteger ni){
            if(ni.isInteger())  list.add(ni.getInteger());
            List<NestedInteger> nestedList = ni.getList();
            for(NestedInteger nii:nestedList)    helper(nii);
        }

        @Override
        public Integer next() {
            return list.get(++p);
        }

        @Override
        public boolean hasNext() {
            return p+1<list.size();
        }
    }
}
