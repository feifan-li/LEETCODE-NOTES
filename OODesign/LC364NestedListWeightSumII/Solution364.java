package OODesign.LC364NestedListWeightSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution364 {
    public List<Integer> intList = new ArrayList<>();
    public List<Integer> depthList = new ArrayList<>();
    public int depthSumInverse(List<NestedInteger> nestedList) {
        for(NestedInteger ni:nestedList)    getIntegerAndDepth(ni,1);
        assert intList.size()==depthList.size();
        int maxDepth = 1, sum = 0;
        for(int depth:depthList)    maxDepth = Math.max(maxDepth,depth);
        for(int i=0;i<depthList.size();++i)    sum += intList.get(i)*(maxDepth - depthList.get(i) + 1);
        return sum;
    }
    public void getIntegerAndDepth(NestedInteger ni,int niDepth){
        if(ni.isInteger()){
            intList.add(ni.getInteger());
            depthList.add(niDepth);
            return;
        }
        if(ni.getList()==null || ni.getList().size()==0){
            intList.add(0);//invalid
            depthList.add(niDepth);
            return;
        }
        for(NestedInteger nii:ni.getList())    getIntegerAndDepth(nii,niDepth+1);
    }
}
