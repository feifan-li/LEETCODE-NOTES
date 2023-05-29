package CompanyQuestions.HuaweiJishi.HJ70矩阵乘法计算量估计;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] dim = new int[n][2];
        for(int i=0;i<n;++i){
            dim[i][0] = in.nextInt();
            dim[i][1] = in.nextInt();
        }
        String s = in.next();
        long res = 0;
        Stack<int[]> dimStack = new Stack<>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='(')    continue;
            if(s.charAt(i)-'A'>=0 && s.charAt(i)-'Z'<=0){
                dimStack.push(new int[]{dim[s.charAt(i)-'A'][0],dim[s.charAt(i)-'A'][1]});
            }else if(s.charAt(i)==')'){
                int[] right = dimStack.pop();
                int[] left = dimStack.pop();
                res += left[0]*right[1]*left[1];
                dimStack.push(new int[]{left[0],right[1]});
            }
        }
        assert dimStack.isEmpty();
        System.out.println(res);
    }
}
