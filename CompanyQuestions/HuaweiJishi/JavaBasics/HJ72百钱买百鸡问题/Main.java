package CompanyQuestions.HuaweiJishi.JavaBasics.HJ72百钱买百鸡问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        //x>=0 的整数
        //y>=0 的整数
        //z>=0 的整数
        //x+y+z = 100
        //5x+3y+z/3 = 100    =>   y = 25-7x/4, z = 75+3x/4   => x=0,4,8,12,(舍去16,...)
        System.out.println(0+" "+25+" "+75);
        System.out.println(4+" "+18+" "+78);
        System.out.println(8+" "+11+" "+81);
        System.out.println(12+" "+4+" "+84);
    }
}
