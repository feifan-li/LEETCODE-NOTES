package LC459RepeatedSubstringPattern;

public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,2*s.length()-1).contains(s);
    }
}
