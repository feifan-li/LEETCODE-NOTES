package CompanyQuestions.HuaweiJishi.HJ39判断两个IP是否属于同一子网;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] maskSegs = in.nextLine().split("\\.");
        String[] ip1Segs = in.nextLine().split("\\.");
        String[] ip2Segs = in.nextLine().split("\\.");
        if(!isValidIp(ip1Segs) || !isValidIp(ip2Segs) || !isValidMask(maskSegs)){
            System.out.println("1");
            return;
        }
        for(int i=0;i<4;++i){
            int maskSeg = Integer.parseInt(maskSegs[i]);
            int ip1Seg = Integer.parseInt(ip1Segs[i]);
            int ip2Seg = Integer.parseInt(ip2Segs[i]);
            if((ip1Seg&maskSeg)!=(ip2Seg&maskSeg)){
                System.out.println("2");
                return;
            }
        }
        System.out.println("0");
    }
    private static boolean isValidIp(String[] segs){
        if(segs.length!=4)  return false;
        for(String seg:segs){
            if(seg.length()>3)  return false;
            if(Integer.parseInt(seg)>255 || Integer.parseInt(seg)<0)    return false;
        }
        return true;
    }
    private static boolean isValidMask(String[] segs){
        if(!isValidIp(segs)){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for(String seg:segs){
            String binaries = Integer.toBinaryString(Integer.parseInt(seg));
            for(int cnt=0;cnt<8-binaries.length();++cnt){
                sb.append('0');
            }
            sb.append(binaries);
        }
        int last1 = sb.toString().lastIndexOf('1');
        int first0 = sb.toString().indexOf('0');
        if(last1==sb.length()-1 || first0==0 || last1>first0){
            return false;
        }
        return true;
    }
}
