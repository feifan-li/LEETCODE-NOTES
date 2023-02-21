package LC520DetectCapitals;

public class Solution520 {
    public static boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i=0;i<word.length();++i){
            if(word.charAt(i)-'A'<=25) count++;
        }
        if(count==0) return true;
        else if(count==word.length()) return true;
        else if(count==1 && word.charAt(0)-'A'<=25) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println('Z'-'A');
    }
}
