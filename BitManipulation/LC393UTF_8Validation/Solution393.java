package BitManipulation.LC393UTF_8Validation;

public class Solution393 {
    public boolean validUtf8(int[] data) {
        int n = data.length;//number of bytes
        if(n==1)    return data[0]<=127;
        int i=0;
        while(i<n){
            if(data[i]<=127)  i++;
            else if(data[i]<=223 && data[i]>=192){
                if(data[i+1]>=128 && data[i+1]<=191)    i += 2;
                else    return false;
            }else if(data[i]<=239 && data[i]>=224){
                if(data[i+1]>=128 && data[i+1]<=191 && data[i+2]>=128 && data[i+2]<=191)    i += 3;
                else    return false;
            }else if(data[i]<=247 && data[i]>=240){
                if(data[i+1]>=128 && data[i+1]<=191 && data[i+2]>=128 && data[i+2]<=191
                        && data[i+3]>=128 && data[i+3]<=191)    i += 4;
                else    return false;
            }else   return false;
        }
        return true;
    }
}
