package CompanyQuestions.HuaweiJishi.DFS.HJ67_24点游戏算法;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i=0;i<4;++i){
            nums[i] = in.nextInt();
        }
        for(int target:dfs(nums[0],nums[1],nums[2],nums[3])){
            if(target==24){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    private static HashSet<Integer> dfs(int a,int b){
        HashSet<Integer> ans = new HashSet<>();
        ans.add(a*b);
        ans.add(a+b);
        ans.add(a-b);
        ans.add(b-a);
        if(b!=0 && a%b==0)  ans.add(a/b);
        if(a!=0 && b%a==0)  ans.add(b/a);
        return ans;
    }
    private static HashSet<Integer> dfs(int a,int b,int c){
        HashSet<Integer> ans = new HashSet<>();
        int[][] arr = new int[][]{{a,b,c}, {b,a,c}, {c,a,b},};
        for(int i=0;i<arr.length;++i){
            for(int j :dfs(arr[i][1],arr[i][2])){
                ans.add(arr[i][0]+j);
                ans.add(arr[i][0]*j);
                ans.add(arr[i][0]-j);
                ans.add(j-arr[i][0]);
                if(j!=0 && arr[i][0]%j==0)  ans.add(arr[i][0]/j);
                if(arr[i][0]!=0 && j%arr[i][0]==0)  ans.add(j/arr[i][0]);
            }
        }
        return ans;
    }
    private static HashSet<Integer> dfs(int a,int b,int c,int d){
        HashSet<Integer> ans = new HashSet<>();
        int[][] arr1 = new int[][]{{a,b,c,d}, {b,a,c,d}, {c,a,b,d}, {d,a,b,c},};
        for(int i=0;i<arr1.length;++i){
            for(int j :dfs(arr1[i][1],arr1[i][2],arr1[i][3])){
                ans.add(arr1[i][0]+j);
                ans.add(arr1[i][0]*j);
                ans.add(arr1[i][0]-j);
                ans.add(j-arr1[i][0]);
                if(j!=0 && arr1[i][0]%j==0)  ans.add(arr1[i][0]/j);
                if(arr1[i][0]!=0 && j%arr1[i][0]==0)  ans.add(j/arr1[i][0]);
            }
        }
        int[][] arr2 = new int[][]{{a,b,c,d}, {a,c,b,d}, {a,d,b,c},};
        for(int k=0;k<arr2.length;++k){
            for(int i:dfs(arr2[k][0],arr2[k][1])){
                for(int j:dfs(arr2[k][2],arr2[k][3])){
                    ans.add(i+j);
                    ans.add(i*j);
                    ans.add(i-j);
                    ans.add(j-i);
                    if(j!=0 && i%j==0)  ans.add(i/j);
                    if(i!=0 && j%i==0)  ans.add(j/i);
                }
            }
        }
        return ans;
    }
}
