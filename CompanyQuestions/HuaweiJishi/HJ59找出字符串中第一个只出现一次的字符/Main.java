package CompanyQuestions.HuaweiJishi.HJ59找出字符串中第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] arr = in.nextLine().toCharArray();
        HashMap<Character,int[]> map = new HashMap<>();//第一次出现的位置 出现的次数
        for(int i=0;i<arr.length;++i){
            if(!map.containsKey(arr[i]))    map.put(arr[i],new int[]{i,1});
            else{
                int[] freq = map.get(arr[i]);
                map.put(arr[i],new int[]{freq[0],freq[1]+1});
            }
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Character,int[]> pair:map.entrySet()){
            int[] freq = pair.getValue();
            if(freq[1]==1){
                ans = Math.min(ans,freq[0]);
            }
        }
        if(ans==Integer.MAX_VALUE)  System.out.println(-1);
        else System.out.println(arr[ans]);
    }
}
