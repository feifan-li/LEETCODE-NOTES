package CompanyQuestions.HuaweiJishi.HJ71字符串通配符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s1 = toLower(in.next().toCharArray());
        char[] s2 = toLower(in.next().toCharArray());
        String[] segs = String.valueOf(s1).split("\\*");
        if(segs.length==1 && s1.length!=s2.length){
            System.out.println(false);
            return;
        }
        if(s1[0]!='*'){
            if(indexOf(segs[0],s2,0)!=0){
                System.out.println(false);
                return;
            }
        }
        if(s1[s1.length-1]!='*'){
            int index = indexOf(segs[segs.length-1],s2,s2.length-segs[segs.length-1].length());
            if(index==-1 || index!=s2.length-segs[segs.length-1].length()){
                System.out.println(false);
                return;
            }
        }
        int nextStart = 0;
        for(int i=0;i<segs.length;++i){
            if(segs[i]==null || segs[i].length()==0)    continue;
            int start = nextStart;
            int index = indexOf(segs[i],s2,start);
            if(index==-1){
                System.out.println(false);
                return;
            }
            nextStart = index+segs[i].length();
        }
        System.out.println(true);
    }
    private static int indexOf(String s,char[] t,int tStart){
        /**Return the first index in t that matches s**/
        int i = tStart;
        if(tStart<0 || tStart>=t.length)    return -1;
        while(i<t.length){
            boolean matched = true;
            int k = i;
            for(int j=0;j<s.length();++j){
                if(k>=t.length){
                    matched = false;
                    break;
                }
                if(t[k]==s.charAt(j) || (s.charAt(j)=='?' && ((t[k]-'a'>=0 && t[k]-'z'<=0) || (t[k]-'0'>=0 && t[k]-'9'<=0)))) {
                    k++;
                    continue;
                }else{
                    matched = false;
                    break;
                }
            }
            if(matched) return i;
            i++;
        }
        return -1;
    }
    private static char[] toLower(char[] arr){
        for(int i=0;i<arr.length;++i){
            if(arr[i]-'A'>=0 && arr[i]-'Z'<=0)  arr[i] = (char)('a'+arr[i]-'A');
            else continue;
        }
        return arr;
    }
}
