package CompanyQuestions.HuaweiJishi.JavaBasics.HJ38求小球落地5次后所经历的路程和第5次反弹的高度;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float n = in.nextFloat();
        float distance = n/(float)(16);
        for(int i=0;i<4;++i){
            distance += 1.5*n/(float)(1<<i);
        }
        System.out.println(distance);
        System.out.println(n/(float)(32));
    }
}
