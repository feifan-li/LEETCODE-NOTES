package CompanyQuestions.HuaweiJishi.OOD.HJ98自动售货系统;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Grocery{

        private String name;
        private int amount;


        private int price;
        public String getName() {
            return name;
        }
        public int getPrice() {
            return price;
        }
        public int getAmount() {
            return amount;
        }
        public void setAmount(int amount) {
            this.amount = amount;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public Grocery(String name, int price, int amount) {
            this.name = name;
            this.price = price;
            this.amount = amount;
        }
    }
    public static class Change{
        private int value;
        private int amount;
        public int getValue() {
            return value;
        }
        public int getAmount() {
            return amount;
        }
        public void setAmount(int amount) {
            this.amount = amount;
        }
        public Change(int value, int amount) {
            this.value = value;
            this.amount = amount;
        }
    }
    public static class VendingMachine{
        ArrayList<Grocery> groceryList = new ArrayList<>();
        ArrayList<Change> changeList = new ArrayList<>();
        int balance = 0;
        int remainingGoods = 0;
        public VendingMachine(){}
        public VendingMachine(String rcmd){
            String[] groceryAmounts = rcmd.split(" ")[1].split("-");
            assert groceryAmounts.length==6;
            String[] changeAmounts = rcmd.split(" ")[2].split("-");
            assert changeAmounts.length==4;
            for(int i=0;i<6;++i){
                groceryList.add(new Grocery("A"+(i+1),0,Integer.parseInt(groceryAmounts[i])));
                remainingGoods += Integer.parseInt(groceryAmounts[i]);
                if(i==0)   groceryList.get(i).setPrice(2);
                else if(i==1)   groceryList.get(i).setPrice(3);
                else if(i==2)   groceryList.get(i).setPrice(4);
                else if(i==3)   groceryList.get(i).setPrice(5);
                else if(i==4)   groceryList.get(i).setPrice(8);
                else if(i==5)   groceryList.get(i).setPrice(6);
            }
            changeList.add(new Change(1,Integer.parseInt(changeAmounts[0])));
            changeList.add(new Change(2,Integer.parseInt(changeAmounts[1])));
            changeList.add(new Change(5,Integer.parseInt(changeAmounts[2])));
            changeList.add(new Change(10,Integer.parseInt(changeAmounts[3])));

            System.out.println("S001:Initialization is successful");
        }
        public void pay(String pcmd){
            int inBalance = Integer.parseInt(pcmd.split(" ")[1]);
            if(!(inBalance==1 || inBalance==2 || inBalance==5 ||inBalance==10)){
                System.out.println("E002:Denomination error");
                return;
            }else if(1*changeList.get(0).getAmount()+2*changeList.get(1).getAmount()<inBalance){
                System.out.println("E003:Change is not enough, pay fail");
                return;
            }else if(remainingGoods==0){
                System.out.println("E005:All the goods sold out");
                return;
            }
            if(inBalance==1)    changeList.get(0).amount += 1;
            else if(inBalance==2)   changeList.get(1).amount += 1;
            else if(inBalance==5)   changeList.get(2).amount += 1;
            else if(inBalance==10)   changeList.get(3).amount += 1;
            balance += inBalance;
            System.out.println("S002:Pay success,balance="+balance);
        }
        public void buy(String bcmd){
            String groceryName = bcmd.split(" ")[1];
            if(!(groceryName.charAt(0)=='A' && groceryName.charAt(1)-'0'>=1 && groceryName.charAt(1)-'6'<=0)){
                System.out.println("E006:Goods does not exist");
                return;
            }else if(groceryList.get(groceryName.charAt(1)-'1').getAmount()==0){
                System.out.println("E007:The goods sold out");
                return;
            }else if(balance<groceryList.get(groceryName.charAt(1)-'1').getPrice()){
                System.out.println("E008:Lack of balance");
                return;
            }else{
                int id = groceryName.charAt(1)-'1';
                balance -= groceryList.get(id).getPrice();
                int prevAmount = groceryList.get(id).getAmount();
                groceryList.get(id).setAmount(prevAmount-1);
                System.out.println("S003:Buy success,balance="+balance);
            }
        }
        public void getChange(String ccmd){
            if(balance==0){
                System.out.println("E009:Work failure");
                return;
            }
            int ones = 0,twos = 0,fives = 0,tens = 0;
            for(int i=3;i>=0;--i){
                while(changeList.get(i).getAmount()>=1 && changeList.get(i).getValue()<=balance){
                    int amount = changeList.get(i).getAmount();
                    balance -= changeList.get(i).getValue();
                    if(i==3)    tens++;
                    else if(i==2)   fives++;
                    else if(i==1)   twos++;
                    else if(i==0)   ones++;
                    changeList.get(i).setAmount(amount-1);
                }
            }
            System.out.println("1 yuan coin number="+ones);
            System.out.println("2 yuan coin number="+twos);
            System.out.println("5 yuan coin number="+fives);
            System.out.println("10 yuan coin number="+tens);
        }
        public void query(String qcmd){
            if(qcmd.length()!=3){
                System.out.println("E010:Parameter error");
                return;
            }else if(qcmd.length()==3 && (qcmd.charAt(0)!='q' || qcmd.charAt(1)!=' ' || qcmd.charAt(2)-'0'>1
            || qcmd.charAt(2)-'0'<0)){
                System.out.println("E010:Parameter error");
                return;
            }
            if(qcmd.charAt(2)-'0'==0){
                for(int i=0;i<6;++i){
                    System.out.println(groceryList.get(i).getName()+" "+groceryList.get(i).getPrice()+" "+
                            groceryList.get(i).getAmount());
                }
            }else if(qcmd.charAt(2)-'0'==1){
                System.out.println("1 yuan coin number="+changeList.get(0).getAmount());
                System.out.println("2 yuan coin number="+changeList.get(1).getAmount());
                System.out.println("5 yuan coin number="+changeList.get(2).getAmount());
                System.out.println("10 yuan coin number="+changeList.get(3).getAmount());
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] cmds = in.nextLine().split(";");
        VendingMachine vm = new VendingMachine();
        for(int i=0;i<cmds.length;++i){
            String cmd = cmds[i];
            if(cmd.charAt(0)=='r')  vm = new VendingMachine(cmd);
            else if(cmd.charAt(0)=='p') vm.pay(cmd);
            else if(cmd.charAt(0)=='b') vm.buy(cmd);
            else if(cmd.charAt(0)=='c') vm.getChange(cmd);
            else if(cmd.charAt(0)=='q') vm.query(cmd);
        }
    }
}
