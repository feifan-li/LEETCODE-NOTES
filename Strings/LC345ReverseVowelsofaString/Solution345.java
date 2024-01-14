package Strings.LC345ReverseVowelsofaString;

public class Solution345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length-1;
        while(left<=arr.length-1 && right>=0 && left<=right){
            while(left<=Math.min(right,arr.length-1) && !isVowel(arr[left]))  left++;
            while(right>=Math.max(0,left) && !isVowel(arr[right])) right--;
            if(left>right)  break;
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(arr);
    }
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
                c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
