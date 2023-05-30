package CompanyQuestions.HuaweiJishi.Backtrack.HJ89_24点运算;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] cards = in.nextLine().split(" ");
        String[] ops = new String[] {"+", "-", "*", "/"};
        for (String card : cards) {
            if (card.equals("joker") || card.equals("JOKER")) {
                System.out.println("ERROR");
                return;
            }
        }
        assert cards.length == 4;
        HashSet<ArrayList<String>> exps = new HashSet<>();
        for (int i = 0; i < 4; ++i) {
            boolean[] visited = new boolean[4];
            visited[i] = true;
            ArrayList<String> list = new ArrayList<>();
            list.add(cards[i]);
            backtrack(exps, visited, cards, ops, list);
        }
        for (ArrayList<String> exp : exps) {
            Stack<String> stack = new Stack<>();
            int i = 0;
            while (i < exp.size()) {
                if (!(exp.get(i).equals("*") || exp.get(i).equals("/") || exp.get(i).equals("+") || exp.get(i).equals("-"))) {
                    stack.push(exp.get(i));
                    i++;
                } else {
                    int a = cardToInt(stack.pop());
                    int b = cardToInt(exp.get(i + 1));
                    if (exp.get(i).equals("*")) stack.push((a * b) + "");
                    else if (exp.get(i).equals("/")) stack.push((a / b) + "");
                    else if (exp.get(i).equals("+")) stack.push((a + b) + "");
                    else if (exp.get(i).equals("-")) stack.push((a - b) + "");
                    i = i + 2;
                }
            }
            if (stack.pop().equals("24")) {
                System.out.println(exp.get(0) + exp.get(1) + exp.get(2) + exp.get(3) + exp.get(4) + exp.get(5) + exp.get(6));
                return;
            }
        }
        System.out.println("NONE");
    }
    private static void backtrack(HashSet<ArrayList<String>> exps,
                                  boolean[] visited, String[] cards, String[] ops, ArrayList<String> list) {
        if (list.size() == 7) {
            exps.add(new ArrayList<>(list));
            return;
        }
        for (String op : ops) {
            list.add(op);
            for (int i = 0; i < 4; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(cards[i]);
                    backtrack(exps, visited, cards, ops, list);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }
            }
            list.remove(list.size() - 1);
        }
    }
    private static int cardToInt(String card) {
        if (card.equals("A"))    return 1;
        else if (card.equals("J"))   return 11;
        else if (card.equals("Q"))   return 12;
        else if (card.equals("K"))   return 13;
        else return Integer.parseInt(card);
    }
}
