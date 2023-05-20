package CompanyQuestions.HuaweiJishi.JavaBasics.HJ7_取近似值;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        float input = in.nextFloat();
        System.out.println((int)(input+0.5));
    }
}
