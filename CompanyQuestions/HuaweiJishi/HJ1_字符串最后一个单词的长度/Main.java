package CompanyQuestions.HuaweiJishi.HJ1_字符串最后一个单词的长度;

import java.util.Scanner;
/**https://www.nowcoder.com/exam/oj/ta?tpId=37**/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "";
        String[] words;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            s = in.nextLine();
            words = s.split(" ");
            System.out.println(words[words.length-1].length());
        }
    }
}
