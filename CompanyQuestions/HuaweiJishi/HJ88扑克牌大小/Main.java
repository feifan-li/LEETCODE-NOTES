package CompanyQuestions.HuaweiJishi.HJ88扑克牌大小;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int BOMB = 100;
    public static final int KINGS = 1000;
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int TRIPLE = 3;
    public static final int FLUSH = 5;
    public static final int ERROR = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] pairs = in.nextLine().split("-");
        int[] level1AndVal1 = getLevelAndVal(pairs[0]);
        int[] level2AndVal2 = getLevelAndVal(pairs[1]);
        if(level1AndVal1[0]==ERROR || level2AndVal2[0]==ERROR){
            System.out.println("ERROR");
        }else if(level1AndVal1[0]==level2AndVal2[0]){
            if(level1AndVal1[1]>level2AndVal2[1]){
                System.out.println(pairs[0]);
            }else{
                System.out.println(pairs[1]);
            }
        }else if(level1AndVal1[0]<level2AndVal2[0] && (level2AndVal2[0]==BOMB || level2AndVal2[0]==KINGS)){
            System.out.println(pairs[1]);
        }else if(level1AndVal1[0]>level2AndVal2[0] && (level1AndVal1[0]==BOMB || level1AndVal1[0]==KINGS)){
            System.out.println(pairs[0]);
        }else{
            System.out.println("ERROR");
        }
    }
    public static int[] getLevelAndVal(String pair){
        String[] cards = pair.split(" ");
        if(cards.length==1){
            int val = 0;
            if(cards[0].equals("J"))    val = 11;
            else if(cards[0].equals("Q"))   val = 12;
            else if(cards[0].equals("K"))   val = 13;
            else if(cards[0].equals("A"))   val = 14;
            else if(cards[0].equals("2"))   val = 15;
            else if(!(cards[0].equals("joker") || cards[0].equals("JOKER")))    val = Integer.parseInt(cards[0]);
            else if(cards[0].equals("joker"))   val = 20;
            else if(cards[0].equals("JOKER"))   val = 30;
            else return new int[]{ERROR,ERROR};
            return new int[]{SINGLE,val};
        }else if(cards.length==2){
            if(cards[0].equals(cards[1])){
                int val = 0;
                if(cards[0].equals("J"))    val = 11;
                else if(cards[0].equals("Q"))   val = 12;
                else if(cards[0].equals("K"))   val = 13;
                else if(cards[0].equals("A"))   val = 14;
                else if(cards[0].equals("2"))   val = 15;
                else if(!(cards[0].equals("joker") || cards[0].equals("JOKER")))    val = Integer.parseInt(cards[0]);
                else return new int[]{ERROR,ERROR};
                return new int[]{DOUBLE,val};
            }else if(cards[0].equals("joker") && cards[1].equals("JOKER")){
                return new int[]{KINGS,KINGS};
            }else{
                return new int[]{ERROR,ERROR};
            }
        }else if(cards.length==3){
            if(cards[0].equals(cards[1]) && cards[0].equals(cards[2])){
                int val = 0;
                if(cards[0].equals("J"))    val = 11;
                else if(cards[0].equals("Q"))   val = 12;
                else if(cards[0].equals("K"))   val = 13;
                else if(cards[0].equals("A"))   val = 14;
                else if(cards[0].equals("2"))   val = 15;
                else if(!(cards[0].equals("joker") || cards[0].equals("JOKER")))    val = Integer.parseInt(cards[0]);
                else return new int[]{ERROR,ERROR};
                return new int[]{TRIPLE,val};
            }else{
                return new int[]{ERROR,ERROR};
            }
        }else if(cards.length==4){
            if(cards[0].equals(cards[1]) && cards[0].equals(cards[2]) && cards[0].equals(cards[3])){
                int val = 0;
                if(cards[0].equals("J"))    val = 11;
                else if(cards[0].equals("Q"))   val = 12;
                else if(cards[0].equals("K"))   val = 13;
                else if(cards[0].equals("A"))   val = 14;
                else if(cards[0].equals("2"))   val = 15;
                else if(!(cards[0].equals("joker") || cards[0].equals("JOKER")))    val = Integer.parseInt(cards[0]);
                else return new int[]{ERROR,ERROR};
                return new int[]{BOMB,val};
            }else{
                return new int[]{ERROR,ERROR};
            }
        }else if(cards.length>=5){
            int[] flush = new int[cards.length];
            int index = 0;
            for(String card:cards){
                if(card.equals("joker") || card.equals("JOKER"))  return new int[]{ERROR,ERROR};
                int val = 0;
                if(card.equals("J"))    val = 11;
                else if(card.equals("Q"))   val = 12;
                else if(card.equals("K"))   val = 13;
                else if(card.equals("A"))   val = 14;
                else if(card.equals("2"))   val = 15;
                else val = Integer.parseInt(card);
                flush[index] = val;
                index++;
            }
            Arrays.sort(flush);
            return new int[]{FLUSH,flush[0]};
        }

        return new int[]{ERROR,ERROR};
    }
}
