package CompanyQuestions.HuaweiJishi.链表.HJ48从单向链表中删除指定值的节点;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = in.nextInt();
        int headVal = in.nextInt();
        list.add(headVal);
        for(int i=0;i<n-1;++i){//插入n-1次
            int newVal = in.nextInt();
            int afterVal = in.nextInt();
            if(afterVal==headVal){
                list.add(1,newVal);
            }else{
                for(int j=0;j<list.size();++j){
                    if(list.get(j)==afterVal){
                        list.add(j+1,newVal);
                        break;
                    }
                }
            }
        }
        assert list.size()==n;
        int deleteVal = in.nextInt();
        for(int i=0;i<n;++i){
            if(list.get(i)!=deleteVal)  System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
