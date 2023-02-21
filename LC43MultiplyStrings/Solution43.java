package LC43MultiplyStrings;

public class Solution43 {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] digits = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;--i){
            for(int j=num2.length()-1;j>=0;--j){
                int cur = i+j+1,high = i+j;
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = product+digits[cur];
                digits[cur] = sum%10;
                digits[high] += sum/10;
            }
        }
        StringBuilder res = new StringBuilder();
        if(digits[0]!=0) res.append(digits[0]);
        for(int i=1;i<digits.length;++i){
            res.append(digits[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("99","99"));
        System.out.println(multiply("2","3"));
        System.out.println(multiply("123","456"));
    }
}
