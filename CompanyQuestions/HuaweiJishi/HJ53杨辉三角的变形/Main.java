package CompanyQuestions.HuaweiJishi.HJ53杨辉三角的变形;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=2)    System.out.println("-1");//1 2
        else if(n%2==1) System.out.println("2");//3 5 7 9 ...
        else if((n/2)%2==0) System.out.println("3");//4 8 12 ...
        else System.out.println("4");//6 10 14 ...
        //1                       -1
        //1 1                     -1
        //1 2 odd odd
        //1 3 even odd            3
        //1 4 even even
        //1 5 odd even            4
        //1 6 odd even
        //1 7 even odd            3
        //1 8 even even
        //1 9 odd even            4
        //1 10 odd even
        //1 11 even odd           3
        //1 12 even even
        //1 13 odd even           4
    }
}
