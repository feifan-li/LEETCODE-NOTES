package CompanyQuestions.HuaweiJishi.HJ64_MP3光标位置;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ops = in.next();
        int[] list = new int[n];
        for(int i=0;i<n;++i)    list[i] = i+1;
        int mouse = 0;
        if(n<=4){
            for(int i=0;i<ops.length();++i){
                if(ops.charAt(i)=='U')  mouse = mouse-1<0?n-1:mouse-1;
                else if(ops.charAt(i)=='D') mouse = (mouse+1)%n;
            }
            for(int i=0;i<n;++i)    System.out.print(list[i]+" ");
        }else{
            int left = 0, right = left+3;
            for(int i=0;i<ops.length();++i){
                if(ops.charAt(i)=='U'){
                    if(left==0 && mouse == left){
                        mouse = n-1;
                        right = mouse;
                        left = right-3;
                    }else if(mouse==left){
                        left--;
                        mouse--;
                        right--;
                    }else{
                        mouse--;
                    }
                }else if(ops.charAt(i)=='D'){
                    if(right==n-1 && mouse==right){
                        mouse = 0;
                        left = mouse;
                        right = left+3;
                    }else if(mouse==right){
                        right++;
                        mouse++;
                        left++;
                    }else{
                        mouse++;
                    }
                }
            }
            for(int i=left;i<=right;++i)    System.out.print(list[i]+" ");
        }
        System.out.println();
        System.out.println(list[mouse]);
    }
}
