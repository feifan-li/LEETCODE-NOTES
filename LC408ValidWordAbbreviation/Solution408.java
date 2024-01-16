package LC408ValidWordAbbreviation;

public class Solution408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m= word.length(), n = abbr.length();
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        while(j<n){
            if(!isDigit(abbr.charAt(j))){
                sb.append(abbr.charAt(j));
                j++;
            }else{
                if(abbr.charAt(j)=='0'){
                    return false;//leading zeros not allowed
                }
                int start = j;
                while(j<n && isDigit(abbr.charAt(j))){
                    j++;
                }
                if(j-start > lengthOfDigits(m)){
                    return false;
                }
                for(i=0;i<Integer.parseInt(abbr.substring(start,j));++i){
                    sb.append('0');
                }
            }
        }
        if(word.length()!=sb.length()){
            return false;
        }
        for(i=0;i<word.length();++i){
            if(sb.charAt(i)!='0' && sb.charAt(i)!=word.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public boolean isDigit(char c){
        return c-'0'>=0 && c-'0'<=9;
    }
    public int lengthOfDigits(int m){
        int len = 0;
        while(m>0){
            m /= 10;
            len ++;
        }
        return len;
    }
}
