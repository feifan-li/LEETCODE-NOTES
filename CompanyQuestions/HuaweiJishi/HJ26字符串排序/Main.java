package CompanyQuestions.HuaweiJishi.HJ26字符串排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static class Pair{
        public int index;
        public char val;
        public Pair(int i,char c){
            index = i;
            val = c;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.nextLine().toCharArray();
        ArrayList<Pair> pairs = new ArrayList<>();
        HashMap<Integer,Character> nonAlphabet = new HashMap<>();
        for(int i=0;i<str.length;++i){
            if(!inAlphabet(str[i])){
                nonAlphabet.put(i,str[i]);
            }else{
                pairs.add(new Pair(i,str[i]));
            }
        }
        pairs.sort((a,b)->(toLower(a.val)==toLower(b.val)?a.index-b.index:toLower(a.val)-toLower(b.val)));
        StringBuilder sb = new StringBuilder();
        int i = 0,j = 0;
        while(i<str.length){
            if(nonAlphabet.containsKey(i)){
                sb.append(nonAlphabet.get(i));
            }else{
                sb.append(pairs.get(j).val);
                j++;
            }
            i++;
        }
        System.out.println(sb.toString());
    }
    private static boolean inAlphabet(char c){
        if(c-'a'>=0 && c-'z'<=0){
            return true;
        }else if(c-'A'>=0 && c-'Z'<=0){
            return true;
        }
        return false;
    }
    private static char toLower(char c){
        if(c-'A'>=0 && c-'Z'<=0){
            int offset = c-'A';
            return (char)('a'+offset);
        }
        return c;
    }
}
