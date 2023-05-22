package CompanyQuestions.HuaweiJishi.HJ19简单错误记录;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();//enqueue when filename first time appears
        HashMap<String,Integer> freq = new HashMap<>();
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            String wholeName = s[0];
            String lineNum = s[1];
            int fileNameStart = wholeName.lastIndexOf('\\');
            String filename = wholeName.length()-fileNameStart-1>16?wholeName.substring(wholeName.length()-16,wholeName.length()):wholeName.substring(fileNameStart+1,wholeName.length());
            String record = filename+" "+lineNum;
            freq.put(record,freq.getOrDefault(record,0)+1);
            if(freq.get(record)==1){//enqueue when filename first time appears
                if(q.size()==8) q.poll();
                q.offer(record);
            }
        }
        while(!q.isEmpty()){
            String record = q.poll();
            System.out.println(record+' '+freq.get(record));
        }
    }
}
