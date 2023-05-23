package CompanyQuestions.HuaweiJishi.JavaBasics.HJ34图片整理;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        Arrays.sort(s);
        System.out.println(String.valueOf(s));
    }
}
