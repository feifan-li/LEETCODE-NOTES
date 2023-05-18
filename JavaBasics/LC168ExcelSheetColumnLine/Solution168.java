package JavaBasics.LC168ExcelSheetColumnLine;

public class Solution168 {
    private long[] pow26 = new long[8];
    private long[][] range = new long[8][2];
    private StringBuilder ans = new StringBuilder();
    public String convertToTitle(int num) {
        pow26[0] = 1;
        for(int i=1;i<8;++i){
            pow26[i] = pow26[i-1]*26;
        }
        range[1][0] = 1; range[1][1] = 26;
        for(int len = 2;len<8;++len){
            range[len][0] = range[len-1][1]+1;
            range[len][1] = 26*range[len][0];
        }
        int length = binarySearchColLen(num);
        assert(length>0);
        //num must fit in an excel column of length length
        fitTargetToExcelColumn((long)num,length);
        return ans.toString();
    }
    private void fitTargetToExcelColumn(long target,int len){
        if(len==1){
            char cur = (char)('A'+target-1);
            ans.append(cur);
            return;
        }
        char cur = (char)('A'+binarySearchMSB(target,len)-1);
        ans.append(cur);
        int offset = cur-'A'+1;
        long remain = target-offset*pow26[len-1];
        fitTargetToExcelColumn(remain,len-1);
    }
    private int binarySearchColLen(int target){
        int left = 1,right = 7;
        while(left<=right){
            int mid = (left+right)/2;
            if(target>=range[mid][0] && target<=range[mid][1]){
                return mid;
            }else if(target<range[mid][0]){
                right = mid-1;
            }else if(target>range[mid][1]){
                left = mid+1;
            }
        }
        return left;
    }
    private int binarySearchMSB(long target,int len){
        int left = 1,right = 26;
        while(left<=right){
            int mid = (left+right)/2;
            long remain = target-mid*pow26[len-1];
            if(remain>=range[len-1][0] && remain<=range[len-1][1]){
                return mid;
            }else if(remain>range[len-1][1]){
                left = mid+1;
            }else if(remain<range[len-1][0]){
                right = mid-1;
            }
        }
        return left;
    }
}
