package CompanyQuestions.HuaweiJishi.HJ18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = 0, B = 0, C = 0, D = 0, E = 0, ERR = 0, PR = 0;
        while (in.hasNextLine()) {
            String ipAndMask = in.nextLine();
            String ip = ipAndMask.split("~")[0];
            String mask = ipAndMask.split("~")[1];
            String[] _ipSegs = ip.split("\\.");
            int[] ipSegs = new int[4];
            if(_ipSegs[0].equals("0") || _ipSegs[0].equals("127")){
                continue;//just ignore!
            }
            if(invalidMask(mask)||invalidIp(_ipSegs)){
                ERR++;
                continue;
            }
            for(int i=0;i<4;++i)    ipSegs[i] = Integer.parseInt(_ipSegs[i]);
            if(ipSegs[0]>=1 && ipSegs[0]<=126)      A++;
            if(ipSegs[0]>=128 && ipSegs[0]<=191)    B++;
            if(ipSegs[0]>=192 && ipSegs[0]<=223)    C++;
            if(ipSegs[0]>=224 && ipSegs[0]<=239)    D++;
            if(ipSegs[0]>=240 && ipSegs[0]<=255)    E++;
            if(ipSegs[0]==10 || (ipSegs[0]==172 && ipSegs[1]>=16 && ipSegs[1]<=31) || (ipSegs[0]==192 && ipSegs[1]==168)){
                PR++;
            }
        }
        System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+ERR+" "+PR);
    }
    private static boolean invalidIp(String[] ipSegs){
        if(ipSegs.length!=4)    return true;
        for(String seg:ipSegs){
            if(Integer.parseInt(seg)<0||Integer.parseInt(seg)>255)    return true;
        }
        return false;
    }
    private static boolean invalidMask(String mask){
        String[] maskSegs = mask.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;++i){
            sb.append(to8BitBinaryString(Integer.parseInt(maskSegs[i])));
        }
        int last1 = sb.toString().lastIndexOf('1');
        int first0 = sb.toString().indexOf('0');
        if(last1==-1 || first0==-1) return true;
        if(last1>first0)    return true;
        return false;
    }
    private static String to8BitBinaryString(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(num));
        while(sb.length()<8){
            sb.insert(0,'0');
        }
        return sb.toString();
    }
}
