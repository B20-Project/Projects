package BlackJack;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class blackjack {
    static int order=4;
    public static void main(String[] args) {
        String anotherGame="";
        do {
            Scanner scan = new Scanner(System.in);
            String[] cards = Shuffle(Deck());                   //Shuffle cards
            playerMsg(cards);                                //Player's info
            dealer(cards);                                   //Dealer's info
            if (playerSum(cards)[0] == 21) {
                System.out.println("Player wins");          //Blackjack
            } else {
                System.out.println("Player would you like a hit? Type 'h' if yes else 'n'");
                String hit = scan.next();
                if (hit.equals("n")) {
                    NoHit(cards);
                } else {
                    Hit(cards);
                }
            }
                System.out.println("Another game?");
                anotherGame = scan.next();

        } while (anotherGame.equals("yes")) ;

    }
    public static String[] Deck() {
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"CLUB", "DIAMOND", "SPADE", "HEART"};
        String[] cards = new String[52];
        int countCard = 0;
        for (String s : values) {
            for (String suit : suits) {
                cards[countCard] = s + " " + suit;
                countCard++;
            }
        }
        return cards;
    }
    public static String[] Shuffle(String[] shuffle) {
        Random random = new Random();
        for (int i = 0; i < shuffle.length; i++) {
            int randNum = random.nextInt(52);
            String temp = shuffle[randNum];
            shuffle[randNum] = shuffle[i];
            shuffle[i] = temp;
        }
        return shuffle;
    }
    public static String[] PlayersCard(String []temp){
        String []player=new String[2];
        player[0]=temp[0];
        player[1]=temp[1];
        return player;
    }
    public static void playerMsg(String []cards){
        String[]playerCard={PlayersCard(cards)[0],PlayersCard(cards)[1]};
        System.out.println("Players card:");
        System.out.println(playerCard[0]);
        System.out.println(playerCard[1]);
        System.out.print("Player has total value of: ");
        if(playerSum(cards)[1]!=0){
            System.out.println(playerSum(cards)[0]+" or "+playerSum(cards)[1]);
        }
        else{
            System.out.println(playerSum(cards)[0]);
        }
        System.out.println();
    }
    public static int[] playerSum(String[]cards){
        int []sum=new int[2];
        if(cards[0].charAt(0)=='J'||cards[0].charAt(0)=='Q'||cards[0].charAt(0)=='K'||cards[0].charAt(0)=='1'){
            sum[0]=10;
        }
        else if(cards[0].charAt(0)=='A'){
            sum[0]=11;

        }
        else{
            sum[0]=Integer.parseInt(cards[0].substring(0,1));
        }
        if(cards[1].charAt(0)=='J'||cards[1].charAt(0)=='Q'||cards[1].charAt(0)=='K'||cards[1].charAt(0)=='1'){
            if(sum[0]==11){
                sum [0]= 21;
            }
            else{
                sum [0]+= 10;
            }

        }
        else if(cards[1].charAt(0)=='A'){
            if(sum[0]==11){
                sum[0]=2;
            }
            else if(sum[0]==10){
                sum[0]=21;
            }
            else{
                sum[0]+=11;
                sum[1]=sum[0]-10;
            }
        }
        else{
            if(sum[0]==11){
                sum[0]+=Integer.parseInt(cards[1].substring(0,1));
                sum[1]=sum[0]-10;
            }
            else {
                sum[0]+=Integer.parseInt(cards[1].substring(0,1));
            }
        }
        return sum;
    }
    public static String[] DealersCard(String []temp){
        String []dealer=new String[2];
        dealer[0]=temp[2];
        dealer[1]=temp[3];
        return dealer;
    }
    public static void dealer(String[]cards){
        String[]dealersCard={DealersCard(cards)[0],DealersCard(cards)[1]};
        System.out.println("Dealers first card");
        System.out.println(dealersCard[0]);
        System.out.print("Dealer has value of:");
        if(dealersCard[0].charAt(0)=='1'||dealersCard[0].charAt(0)=='J'||dealersCard[0].charAt(0)=='Q'||
                dealersCard[0].charAt(0)=='K'){
            System.out.println(10);
        }
        else if(dealersCard[0].charAt(0)=='A'){
            System.out.println(11+" or "+1);
        }
        else{
            System.out.println(Integer.parseInt(dealersCard[0].substring(0,1)));
        }
        System.out.println();
    }
    public static int[] dealerSum(String[]cards){
        int []sum=new int[2];
        if(cards[2].charAt(0)=='J'||cards[2].charAt(0)=='Q'||cards[2].charAt(0)=='K'||cards[2].charAt(0)=='1'){
            sum[0]=10;
        }
        else if(cards[2].charAt(0)=='A'){
            sum[0]=11;

        }
        else{
            sum[0]=Integer.parseInt(cards[2].substring(0,1));
        }
        if(cards[3].charAt(0)=='J'||cards[3].charAt(0)=='Q'||cards[3].charAt(0)=='K'||cards[3].charAt(0)=='1'){
            if(sum[0]==11){
                sum [0]= 21;
            }
            else{
                sum [0]+= 10;
            }
        }
        else if(cards[3].charAt(0)=='A'){
            if(sum[0]==11){
                sum[0]=2;
            }
            else if(sum[0]==10){
                sum[0]=21;
            }
            else{
                sum[0]+=11;
                sum[1]=sum[0]-10;
            }
        }
        else{
            if(sum[0]==11){
                sum[0]+=Integer.parseInt(cards[3].substring(0,1));
                sum[1]=sum[0]-10;
            }
            else {
                sum[0]+=Integer.parseInt(cards[3].substring(0,1));
            }
        }
        return sum;
    }
    public static void NoHit(String[]cards){
        int sum=0;
        String[]dealersCard={DealersCard(cards)[0],DealersCard(cards)[1]};
        System.out.println("Dealers second card");
        System.out.println(dealersCard[1]);
        System.out.print("Dealer has value of:");
        if(dealerSum(cards)[1]!=0){
            System.out.println(dealerSum(cards)[0]+" or "+dealerSum(cards)[1]);
        }
        else{
            sum=dealerSum(cards)[0];
            System.out.println(sum);
        }
       if(dealerSum(cards)[0]==21){
           System.out.println("Dealer wins");
       }
       else if(dealerSum(cards)[0]<17){
           System.out.println(cards[order]);
           if(cards[order].charAt(0)=='A'){
               if(dealerSum(cards)[1]!=0){
                   sum=dealerSum(cards)[0]+1;
               }
               else{
                   if(dealerSum(cards)[0]+11>21){
                       sum=dealerSum(cards)[0]+1;
                   }
                   else{
                       sum=dealerSum(cards)[0]+11;
                   }
               }
           }
           else if(cards[order].charAt(0)=='1'||cards[order].charAt(0)=='J'||cards[order].charAt(0)=='K'||
                   cards[order].charAt(0)=='Q'){
               if(dealerSum(cards)[1]!=0){
                   sum=dealerSum(cards)[0];
               }
               else{
                   sum=dealerSum(cards)[0]+10;
               }
           }
           else{
               if(dealerSum(cards)[1]!=0){
                   if(dealerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1))>21){
                       sum=dealerSum(cards)[1]+Integer.parseInt(cards[order].substring(0,1));
                   }
                   else{
                       sum=dealerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1));
                   }
               }
               else{
                   sum=dealerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1));
               }
           }
           System.out.println("Dealer now has "+sum);

           order++;
           if(sum<17){
               do{
                   System.out.println(cards[order]);
                   if(cards[order].charAt(0)=='A'){
                       if(sum+11>21){
                           sum=sum+1;
                       }
                       else{
                           sum=sum+11;
                       }
                   }
                   else{
                       if(cards[order].charAt(0)=='1'||cards[order].charAt(0)=='J'||cards[order].charAt(0)=='Q'||
                               cards[order].charAt(0)=='K'){
                           sum+=10;
                       }
                       else{
                           sum+=Integer.parseInt(cards[order].substring(0,1));
                       }
                   }
                   System.out.println("Dealer now has "+sum);
                   order++;
               }while(sum<17);
           }
           System.out.println();

       }
       if(sum>21){
           System.out.println("Player wins");
       }
       else if(sum==21){
           System.out.println("Dealer wins");
       }
       else if(sum>playerSum(cards)[0]){
           System.out.println("Dealer wins");
       }
       else if(sum<playerSum(cards)[0]){
           System.out.println("Player wins");
       }

       else{
           System.out.println("it's a tie");
       }

    }
    public static void Hit(String[]cards){
        Scanner scan=new Scanner(System.in);
        String hit="";
        int sum=0;
        System.out.println(cards[order]);
        if(cards[order].charAt(0)=='A'){
            if(playerSum(cards)[1]!=0){
                sum=playerSum(cards)[0]+1;
            }
            else{
                if(playerSum(cards)[0]+11>21){
                    sum=playerSum(cards)[0]+1;
                }
                else{
                    sum=playerSum(cards)[0]+11;
                }
            }
        }
        else if(cards[order].charAt(0)=='1'||cards[order].charAt(0)=='J'||cards[order].charAt(0)=='K'||
                cards[order].charAt(0)=='Q'){
            if(playerSum(cards)[1]!=0){
                sum=playerSum(cards)[0];
            }
            else{
                sum=playerSum(cards)[0]+10;
            }
        }
        else{
            if(playerSum(cards)[1]!=0){
                if(playerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1))>21){
                    sum=playerSum(cards)[1]+Integer.parseInt(cards[order].substring(0,1));
                }
                else{
                    sum=playerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1));
                }
            }
            else{
                sum=playerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1));
            }
        }
        if(sum>21){
            System.out.println(sum);
            System.out.println("Dealer wins");
        }
        else if(sum==21){
            System.out.println(sum);
            System.out.println("Player wins");
        }
        else {
            System.out.println("Player now has " + sum);
            order++;
            do {
                System.out.println("Would you like another hit? Type 'h' if yes else 'n");
                hit = scan.next();
                if (hit.equals("h")) {
                    System.out.println(cards[order]);
                    if (cards[order].charAt(0) == 'A') {
                        if (sum + 11 > 21) {
                            sum = sum + 1;
                        } else {
                            sum = sum + 11;
                        }
                    } else {
                        if (cards[order].charAt(0) == '1' || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'Q' ||
                                cards[order].charAt(0) == 'K') {
                            sum += 10;
                        } else {
                            sum += Integer.parseInt(cards[order].substring(0, 1));
                        }
                    }
                    System.out.println("player now has " + sum);
                    order++;
                }
            } while (hit.equals("h")&&sum<21);

        if(sum>21){
            System.out.println("Dealer wins");
        }
        else if(sum==21){
            System.out.println("Player wins");
        }
        }

        if(hit.equals("n")){
            order++;
            int dealerSum=0;
            String[]dealersCard={DealersCard(cards)[0],DealersCard(cards)[1]};
            System.out.println("Dealers second card");
            System.out.println(dealersCard[1]);
            System.out.print("Dealer has value of:");
            if(dealerSum(cards)[1]!=0){
                System.out.println(dealerSum(cards)[0]+" or "+dealerSum(cards)[1]);
            }
            else{
                dealerSum=dealerSum(cards)[0];
                System.out.println(dealerSum);
            }
            if(dealerSum(cards)[0]==21){
                System.out.println("Dealer wins");
            }
            else if(dealerSum(cards)[0]<17){
                System.out.println(cards[order]);
                if(cards[order].charAt(0)=='A'){
                    if(dealerSum(cards)[1]!=0){
                        dealerSum=dealerSum(cards)[0]+1;
                    }
                    else{
                        if(dealerSum(cards)[0]+11>21){
                            dealerSum=dealerSum(cards)[0]+1;
                        }
                        else{
                            dealerSum=dealerSum(cards)[0]+11;
                        }
                    }
                }
                else if(cards[order].charAt(0)=='1'||cards[order].charAt(0)=='J'||cards[order].charAt(0)=='K'||
                        cards[order].charAt(0)=='Q'){
                    if(dealerSum(cards)[1]!=0){
                        dealerSum=dealerSum(cards)[0];
                    }
                    else{
                        dealerSum=dealerSum(cards)[0]+10;
                    }
                }
                else{
                    if(dealerSum(cards)[1]!=0){
                        if(dealerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1))>21){
                            dealerSum=dealerSum(cards)[1]+Integer.parseInt(cards[order].substring(0,1));
                        }
                        else{
                            dealerSum=dealerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1));
                        }
                    }
                    else{
                        dealerSum=dealerSum(cards)[0]+Integer.parseInt(cards[order].substring(0,1));
                    }
                }
                System.out.println("Dealer now has "+dealerSum);

                order++;
                if(dealerSum<17){
                    do{
                        System.out.println(cards[order]);
                        if(cards[order].charAt(0)=='A'){
                            if(dealerSum+11>21){
                                dealerSum++;
                            }
                            else{
                                dealerSum+=11;
                            }
                        }
                        else{
                            if(cards[order].charAt(0)=='1'||cards[order].charAt(0)=='J'||cards[order].charAt(0)=='Q'||
                                    cards[order].charAt(0)=='K'){
                                dealerSum+=10;
                            }
                            else{
                                dealerSum+=Integer.parseInt(cards[order].substring(0,1));
                            }
                        }
                        System.out.println("Dealer now has "+dealerSum);
                        order++;
                    }while(dealerSum<17);
                }
                System.out.println();
            }
            if(dealerSum>21){
                System.out.println("Player wins");
            }
            else if(dealerSum==21){
                System.out.println("Dealer wins");
            }
            else if(dealerSum<sum){
                System.out.println("Player wins");
            }
            else if(dealerSum>sum){
                System.out.println("Dealer wins");
            }
            else{
                System.out.println("It's a tie");
            }


        }
        System.out.println();



    }
}









