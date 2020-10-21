package BlackJack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class scratch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[]values={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits={"CLUB","DIAMOND","SPADE","HEART"};
        String []cards=new String[52];
        int countCard=0;
        System.out.println("Welcome to blackjack");
        for (String s : values) {
            for (String suit : suits) {
                cards[countCard] = s + " " + suit;
                countCard++;
            }
        }
        Random random=new Random();
        for (int i = 0; i <cards.length ; i++) {
            int randNum=random.nextInt(52);
            String temp=cards[randNum];
            cards[randNum]=cards[i];
            cards[i]=temp;
        }
        int order=0;
        int sumPlayer=0;
        String playersCard1=cards[order];
        order++;
        String playersCard2=cards[order];
        order++;
        System.out.println("Players cards:");
        System.out.println(playersCard1);
        System.out.println(playersCard2);
        if(playersCard1.substring(0,2).equals("10")||playersCard1.charAt(0)=='J'||playersCard1.charAt(0)=='K'||
        playersCard1.charAt(0)=='Q'){
            sumPlayer=10;
        }
        else if(Character.isDigit(playersCard1.charAt(0))){
            sumPlayer=Integer.parseInt(playersCard1.substring(0,1));
        }
        else if(playersCard1.charAt(0)=='A'){
            System.out.println("1 or 11");
            int A=scan.nextInt();
            if(A==1){
                sumPlayer=1;
            }
            else if(A==11){
                sumPlayer=11;
            }
        }

        if(playersCard2.substring(0,2).equals("10")||playersCard2.charAt(0)=='J'||playersCard2.charAt(0)=='K'||
                playersCard2.charAt(0)=='Q'){
           sumPlayer+=10;
        }
        else if(Character.isDigit(playersCard2.charAt(0))){
            sumPlayer+=Integer.parseInt(playersCard2.substring(0,1));
        }
        else if(playersCard2.charAt(0)=='A'){
            System.out.println("1 or 11");
            int A=scan.nextInt();
            if(A==1){
                sumPlayer+=1;
            }
            else if(A==11){
               sumPlayer+=11;
            }
        }
        System.out.println("Player has total "+sumPlayer);
        System.out.println();
        String dealersCard1=cards[order];
        order++;
        String dealersCard2=cards[order];
        System.out.println("Dealers cards:");
        System.out.println(dealersCard1);
        System.out.println("[Hidden]");

        int sumDealer=0;
        if(dealersCard1.substring(0,2).equals("10")||dealersCard1.charAt(0)=='J'||dealersCard1.charAt(0)=='K'||
                dealersCard1.charAt(0)=='Q'){
            sumDealer=10;
        }
        else if(Character.isDigit(dealersCard1.charAt(0))){
            sumDealer=Integer.parseInt(dealersCard1.substring(0,1));
        }
        else if(dealersCard1.charAt(0)=='A'){
            System.out.println("1 or 11");
            int A=scan.nextInt();
            if(A==1){
                sumDealer=1;
            }
            else if(A==11){
                sumDealer=11;
            }
        }
        System.out.println("Dealers first card "+sumDealer);
        System.out.println();
        System.out.println("Player, would you like to hit? If yes tye \'h\' if no type \'n\'" );
        String hitOrNot=scan.next();

    }
}
