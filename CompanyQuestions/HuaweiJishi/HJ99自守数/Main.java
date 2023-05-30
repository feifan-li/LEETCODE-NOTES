package CompanyQuestions.HuaweiJishi.HJ99自守数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        for(int i=0;i<=n;++i){
            int square = i*i;
            String iString = i+"";
            String squareString = square+"";
            if(iString.equals(squareString.substring(squareString.length()-iString.length(),squareString.length()))){
                cnt++;
            }else{
                continue;
            }
        }
        System.out.println(cnt);
    }
}
