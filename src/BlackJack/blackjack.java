package BlackJack;

import java.util.Random;
import java.util.Scanner;

public class blackjack {
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
        String playersCard1=cards[order];
        order++;
        String playersCard2=cards[order];
        System.out.println(playersCard1);
        System.out.println(playersCard2);



        }
    }

