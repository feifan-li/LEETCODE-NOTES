package CompanyQuestions.HuaweiJishi.JavaBasics.HJ83二维数组操作;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        while(in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            boolean isInitialized = true;
            if(m>9 || n>9 || m<=0 || n<=0){
                isInitialized = false;
                ans.add(-1);
            }else{
                ans.add(0);
            }
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            if(!(x1>=0 && x1<m && y1>=0 && y1<n && x2>=0 && x2<m && y2>=0 && y2<n)){
                ans.add(-1);
            }else{
                ans.add(0);
            }
            int insertRowAbove = in.nextInt();
            if(!(insertRowAbove>=0 && insertRowAbove<m) || m+1>9){
                ans.add(-1);
            }else{
                ans.add(0);
            }
            int insertColLeft = in.nextInt();
            if(!(insertColLeft>=0 && insertColLeft<n) || n+1>9){
                ans.add(-1);
            }else{
                ans.add(0);
            }
            int x = in.nextInt();
            int y = in.nextInt();
            if(!(x>=0 && x<m && y>=0 && y<n)){
                ans.add(-1);
            }else{
                ans.add(0);
            }
        }
        for(int i=0;i<ans.size();++i){
            System.out.println(ans.get(i));
        }
    }
}
