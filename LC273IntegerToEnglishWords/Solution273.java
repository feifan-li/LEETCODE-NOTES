package LC273IntegerToEnglishWords;

public class Solution273 {
    public String[] digits = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public String[] teens = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public String[] tens = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        StringBuilder sb = new StringBuilder();
        convertBillion(sb,num);
        return sb.toString().trim();
    }
    public void convertBillion(StringBuilder sb,int num){
        if(num/1_000_000_000>0)     sb.append(digits[num/1_000_000_000]).append(" ").append("Billion").append(" ");
        convertMillion(sb,num%1_000_000_000);
    }
    public void convertMillion(StringBuilder sb,int num){
        if(num/1_000_000>0){
            StringBuilder prefix = new StringBuilder();
            convertHundred(prefix,num/1_000_000);
            sb.append(prefix.toString().trim()).append(" ").append("Million").append(" ");
        }
        convertThousand(sb,num%1_000_000);
    }
    public void convertThousand(StringBuilder sb,int num){
        if(num/1_000>0){
            StringBuilder prefix = new StringBuilder();
            convertHundred(prefix,num/1_000);
            sb.append(prefix.toString().trim()).append(" ").append("Thousand").append(" ");
        }
        convertHundred(sb,num%1_000);
    }
    public void convertHundred(StringBuilder sb,int num){
        if(num/100>0)   sb.append(digits[num/100]).append(" ").append("Hundred").append(" ");
        convertTens(sb,num%100);
    }
    public void convertTens(StringBuilder sb,int num){
        if(num==0)  return;
        else if(num>=1 && num<=9)   sb.append(digits[num]);
        else if(num>=10 && num<=19) sb.append(teens[num-10]);
        else{
            sb.append(tens[num/10]).append(" ");
            if(num%10!=0)   sb.append(digits[num%10]);
        }
    }
}
