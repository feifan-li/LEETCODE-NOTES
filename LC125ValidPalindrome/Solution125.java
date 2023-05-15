package LC125ValidPalindrome;

public class Solution125 {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0,right = arr.length-1;
        while(left<arr.length && right<arr.length && left!=right){
            if(!isAlphanumeric(arr[left])){
                left++;
                continue;
            }
            if(!isAlphanumeric(arr[right])){
                right--;
                continue;
            }
            if(lower(arr[left])!=lower(arr[right])){
                return false;
            }
            left++;
            right--;
        }
        if(left>arr.length) return false;
        return true;
    }
    private boolean isDigit(char c){
        return (c-'0'>=0) && ('9'-c>=0);
    }
    private boolean isLower(char c){
        return (c-'a'>=0)&&('z'-c>=0);
    }
    private boolean isUpper(char c){
        return (c-'A'>=0)&&('Z'-c>=0);
    }
    private char lower(char c){
        if(isLower(c)||isDigit(c)) return c;
        int offset = c-'A';
        return (char)('a'+offset);
    }
    private boolean isAlphanumeric(char c){
        return isDigit(c)||isLower(c)||isUpper(c);
    }
}
