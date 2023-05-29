package CompanyQuestions.HuaweiJishi.JavaBasics.HJ68成绩排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int way = in.nextInt();
        String[][] students = new String[n][2];
        for(int i=0;i<n;++i){
            students[i][0] = in.next();
            students[i][1] = in.next();
        }
        if(way==0){
            Arrays.sort(students,(a, b)->(Integer.parseInt(b[1])-Integer.parseInt(a[1])));
        }else{
            Arrays.sort(students,(a,b)->(Integer.parseInt(a[1])-Integer.parseInt(b[1])));
        }
        for(int i=0;i<n;++i){
            System.out.print(students[i][0]+" ");
            System.out.println(students[i][1]);
        }
    }
}
