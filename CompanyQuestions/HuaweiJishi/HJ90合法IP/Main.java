package CompanyQuestions.HuaweiJishi.HJ90合法IP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        String[] ipSegs = ip.split("\\.");
        if(ipSegs.length!=4){
            System.out.println("NO");
            return;
        }
        for(String seg:ipSegs){
            if(seg.length()<=0 || seg.length()>3){
                System.out.println("NO");
                return;
            }
            for(int i=0;i<seg.length();++i){
                if(seg.charAt(i)-'0'>=0 && seg.charAt(i)-'9'<=0)    continue;
                else{
                    System.out.println("NO");
                    return;
                }
            }
            int dec = Integer.parseInt(seg);
            if(!(dec>=0 && dec<=255)){
                System.out.println("NO");
                return;
            }
            if(dec>=0 && dec<10 && seg.length()!=1){
                System.out.println("NO");
                return;
            }
            if(dec>=10 && dec<100 && seg.length()!=2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
