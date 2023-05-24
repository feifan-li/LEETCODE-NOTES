package CompanyQuestions.HuaweiJishi.HJ42学英语_数字转英文表示;

import java.util.Scanner;

public class Main {
    public final static String hundred = new String("hundred");
    public final static String thousand = new String("thousand");
    public final static String million = new String("million");
    public final static String[] multipleOfTen = new String[]{
            "xxx","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"
    };
    public final static String[] digit = new String[]{
            "zero","one","two","three","four","five","six","seven","eight","nine"
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        StringBuilder sb = new StringBuilder();
        process(sb,n);
        System.out.println(sb.toString().trim());
    }
    private static void process(StringBuilder sb,long n){
        if(n>=1000000){
            sb.append(digit[(int)(n/1000000)]);
            sb.append(" "+million+" ");
            processLessThan1Million(sb,n%1000000);
        }else{
            processLessThan1Million(sb,n);
        }
    }
    private static void processLessThan1Million(StringBuilder sb,long n){
        assert(n<1000000);
        if(n>=1000){
            long k = n/1000;
            processLessThan1000(sb,k);
            sb.append(" "+thousand);
            if(n%1000!=0)   {
                sb.append(" ");
                processLessThan1000(sb,n%1000);
            }
        }else{
            processLessThan1000(sb,n);
        }
    }
    private static void processLessThan1000(StringBuilder sb,long n){
        assert(n<1000);
        if(n/100>0){
            sb.append(digit[(int)(n/100)]);
            sb.append(" "+hundred);
        }
        if(n%100>0){
            if(n/100!=0)    sb.append(" and ");
            processLessThan100(sb,n%100);
        }
    }
    private static void processLessThan100(StringBuilder sb,long n){
        assert(n<100);
        if(n>=1 && n<10){
            sb.append(digit[(int)n]);
        }else if(n==10){
            sb.append(multipleOfTen[1]);
        }else if(n==11){
            sb.append("eleven");
        }else if(n==12){
            sb.append("twelve");
        }else if(n==13){
            sb.append("thirteen");
        }else if(n==14){
            sb.append("fourteen");
        }else if(n==15){
            sb.append("fifteen");
        }else if(n==16){
            sb.append("sixteen");
        }else if(n==17){
            sb.append("seventeen");
        }else if(n==18){
            sb.append("eighteen");
        }else if(n==19){
            sb.append("nineteen");
        }else if(n>=20 && n<100){
            sb.append(multipleOfTen[(int)(n/10)]);
            if(n%10!=0){
                sb.append(" ");
                sb.append(digit[(int)(n%10)]);
            }
        }
    }
}
