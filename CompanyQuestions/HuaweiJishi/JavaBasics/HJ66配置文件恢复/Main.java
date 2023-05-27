package CompanyQuestions.HuaweiJishi.JavaBasics.HJ66配置文件恢复;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("reset board","board fault");
        map.put("board add","where to add");
        map.put("board delete","no board at all");
        map.put("reboot backplane","impossible");
        map.put("backplane abort","install first");
        ArrayList<String> ans = new ArrayList<String>();
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(" ");
            if(strs.length==1){
                if("reset".contains(strs[0])){
                    ans.add("reset what");
                }else{
                    ans.add("unknown command");
                }
            }else{
                int cnt = 0;
                String output = "";
                for(Map.Entry<String,String> pair:map.entrySet()){
                    if(pair.getKey().split(" ")[0].indexOf(strs[0])==0 && pair.getKey().split(" ")[1].indexOf(strs[1])==0){
                        output += pair.getValue();
                        cnt++;
                    }
                }
                if(cnt!=1)  ans.add("unknown command");
                else ans.add(output);
            }
        }
        for(int i=0;i<ans.size();++i){
            System.out.println(ans.get(i));
        }
    }
}
