package JavaBasics.LC165CompareVersionNumbers;

public class Solution165 {
    public static int compareVersion(String version1, String version2) {
        /** These will not work because dot i a special character in Java's regular expressions,
         * and split(".") will return an empty array
        String[] revision1 = version1.split(".");
        String[] revision2 = version2.split(".");
         **/
        /** To escape, use split("\\.") instead **/
        String[] revision1 = version1.split("\\.");
        String[] revision2 = version2.split("\\.");
        int[] revision1Int = new int[Math.max(revision1.length,revision2.length)];
        int[] revision2Int = new int[Math.max(revision1.length,revision2.length)];
        for(int i=0;i<revision1.length;++i){
            revision1Int[i] = Integer.parseInt(revision1[i]);
        }
        for(int i=0;i<revision2.length;++i){
            revision2Int[i] = Integer.parseInt(revision2[i]);
        }
        for(int i=0;i<Math.max(revision1.length,revision2.length);++i){
            if(revision1Int[i]<revision2Int[i]){
                return -1;
            }else if(revision1Int[i]>revision2Int[i]){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1","1.1"));
    }
}
