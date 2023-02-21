package LC2129CapitalizeTheTitle;
//If the length of the word is 1 or 2 letters, change all letters to lowercase.
//Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
public class Solution2129 {
    public static String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String word:words){
            if(word.length()<=2) ans.append(word.toLowerCase());
            else{
                ans.append(word.substring(0,1).toUpperCase());
                ans.append(word.substring(1,word.length()).toLowerCase());
            }
            ans.append(" ");
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }
}
