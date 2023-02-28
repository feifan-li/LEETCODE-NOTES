package LC71SimplifyPath;

import java.util.HashMap;
import java.util.Map;

public class Solution71 {
    public static String simplifyPath(String path) {
        int curLevel = 0;
        int n = path.length();
        int i = 0;
        Map<Integer,String> map = new HashMap<>();
        while(i<n){
            while(i<n && path.charAt(i)=='/')   i++;
            curLevel = (i==n)?curLevel:curLevel+1;
            StringBuilder sb = new StringBuilder();
            while(i<n && path.charAt(i)!='/'){
                if(path.charAt(i-1)=='/' && path.charAt(i)=='.'){
                    if((i+1<n && path.charAt(i+1)=='/')||i==n-1){
                        curLevel = curLevel-1<=0?0:curLevel-1;
                        i+=1;
                    }else if((i+2<n && path.charAt(i+1)=='.' && path.charAt(i+2)=='/')){
                        curLevel = curLevel-2<=0?0:curLevel-2;
                        i += 2;
                    }else if(i==n-2 && path.charAt(i+1)=='.'){
                        curLevel = curLevel-2<=0?0:curLevel-2;
                        i += 2;
                    }else{
                        while(i<n&&path.charAt(i)!='/') sb.append(path.charAt(i++));
                    }
                }else sb.append(path.charAt(i++));
            }
            if(sb.length()>0) map.put(curLevel,sb.toString());
        }
        if(curLevel<=0) return "/";
        StringBuilder ans = new StringBuilder();
        for(int j=1;j<=curLevel;++j) ans.append("/").append(map.get(j));
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("//home//.././././abc////xyz//./"));
    }
}
