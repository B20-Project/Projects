package BlackJack;
import java.util.Random;
import java.util.Scanner;
public class blackjack {
    String[] cards = Shuffle(Deck());
    public static void main(String[] args) {
       // System.out.println("Welcome to blackjack\nWould you like to play?");
        Scanner scan=new Scanner(System.in);
        String[]cards=Shuffle(Deck());                  //Shuffle
        String[]playerCard={PlayersCard(cards)[0],PlayersCard(cards)[1]};
        System.out.println("Players card:");
        System.out.println(playerCard[0]);      //players first card
        System.out.println(playerCard[1]);      //players second card
       playerSum(playerCard);


        }

    public static String[] Deck(){
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
    public static String[]Shuffle(String[] shuffle){
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

    public static void playerSum(String cards[]){
        int sum=0;
        if(Character.isDigit(cards[0].charAt(0))&&cards[0].charAt(0)!=1){
            sum=Integer.parseInt(cards[0].substring(0,1));
        }
        else if(cards[0].charAt(0)=='A'){
            sum=11;

        }
        else{
            sum=10;
        }
        if(Character.isDigit(cards[1].charAt(0))&&cards[1].charAt(0)!=1){
            if(sum==11){
                sum+=Integer.parseInt(cards[1].substring(0,1));
                System.out.print(sum+" or ");
                System.out.println(sum-10);
            }
            else{
                System.out.println(sum += Integer.parseInt(cards[1].substring(0, 1)));
            }
        }
        else if(cards[1].charAt(0)=='A'){
            if(sum==11){
                sum=2;
                System.out.println(sum);
            }
            else if(sum==10){
                sum=21;
                System.out.println(sum);
            }
            else{
                sum+=11;
                System.out.print(sum+" or ");
                System.out.println(sum -10);
            }
        }
        else{
            if(sum==11){
                sum=21;
            }
            else{
                sum+=10;
            }
            System.out.println(sum);
        }



    }


    }





