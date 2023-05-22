package CompanyQuestions.HuaweiJishi.HJ25数据分类处理;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] I = new String[n];
        for(int i=0;i<n;++i){
            I[i] = in.next();
        }
        TreeSet<Integer> R = new TreeSet<>();
        int m = in.nextInt();
        for(int i=0;i<m;++i){
            R.add(in.nextInt());
        }
        LinkedList<String> buffer = new LinkedList<>();
        while(!R.isEmpty()){
            int ri = R.first();
            R.remove(ri);
            LinkedList<String> pairs = new LinkedList<>();
            for(int i=0;i<n;++i){
                if(I[i].contains(ri+"")){
                    pairs.add(i+"");
                    pairs.add(I[i]);
                }
            }
            if(pairs.size()!=0){
                buffer.add(ri+"");
                buffer.add(pairs.size()/2+"");
                for(String pair:pairs){
                    buffer.add(pair);
                }
            }
        }
        System.out.print(buffer.size()+" ");
        for(String buf:buffer){
            System.out.print(buf+" ");
        }
        System.out.println();
    }
}
