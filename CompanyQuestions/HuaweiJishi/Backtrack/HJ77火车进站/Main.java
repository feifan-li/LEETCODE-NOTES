package CompanyQuestions.HuaweiJishi.Backtrack.HJ77火车进站;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] t = new int[n];
        for(int i=0;i<n;++i){
            t[i] = in.nextInt();
        }
        int nextIn = 1;
        Stack<Integer> outStack = new Stack<>();
        outStack.push(t[0]);
        ArrayList<String> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<Integer>(),t,nextIn,outStack);
        Collections.sort(ans);
        for(int i=0;i<ans.size();++i){
            System.out.println(ans.get(i));
        }
    }
    private static void backtrack(ArrayList<String> ans,ArrayList<Integer> list,int[] t,int nextIn,Stack<Integer> outStack){
        if(list.size()==t.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<list.size();++i)  sb.append(list.get(i)+" ");
            ans.add(sb.toString().trim());
            return;
        }
        if(!outStack.isEmpty()){
            int cur = outStack.pop();
            list.add(cur);
            backtrack(ans,list,t,nextIn,outStack);
            outStack.push(cur);
            list.remove(list.size()-1);
        }
        if(nextIn<t.length){
            outStack.push(t[nextIn]);
            nextIn++;
            backtrack(ans,list,t,nextIn,outStack);
            outStack.pop();
            nextIn--;
        }
    }
}
