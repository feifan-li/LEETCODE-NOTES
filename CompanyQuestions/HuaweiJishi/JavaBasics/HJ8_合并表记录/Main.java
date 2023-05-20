package CompanyQuestions.HuaweiJishi.JavaBasics.HJ8_合并表记录;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer,Long> map = new TreeMap<>();
        int n = in.nextInt();
        for(int cnt = 0;cnt<n;++cnt){
            int index = in.nextInt();
            int val = in.nextInt();
            map.put(index,map.getOrDefault(index,0L)+val);
        }
        for(Map.Entry<Integer,Long> pair:map.entrySet()){
            System.out.print(pair.getKey()+" ");
            System.out.println(pair.getValue());
        }
    }
}
