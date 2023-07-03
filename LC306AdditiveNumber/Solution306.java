package LC306AdditiveNumber;

public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        for(int i=1;i<=num.length()/2;++i){
            for(int j=1;num.length()-i-j>=Math.max(i,j);++j){
                if(isValid(i,j,num))    return true;
            }
        }
        return false;
    }
    public boolean isValid(int i,int j,String num){
        /**i is the length of num1, j is the length of num2 */
        //Numbers cannot have leading zeros:
        if((num.charAt(0)=='0' && i>1)||(num.charAt(i)=='0' && j>1))    return false;
        Long num1 = Long.parseLong(num.substring(0,i));
        Long num2 = Long.parseLong(num.substring(i,i+j));
        Long num3 = 0L;
        for(int num3Start = i+j;num3Start<num.length();num3Start += num3.toString().length()){
            num3 = num1 + num2;
            if(!num.startsWith(num3.toString(),num3Start))  return false;
            num1 = num2;
            num2 = num3;
        }
        return true;
    }
}
