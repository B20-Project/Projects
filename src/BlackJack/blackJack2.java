package BlackJack;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

public class blackJack2 {

    static int order=0;
    static String[]cards=Deck();
    static String[]deck=Shuffle(cards);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deck));
        System.out.println("player has ");
        System.out.println(draw());
        System.out.println(draw());
        System.out.println("player has value of:");
       // System.out.println(value());
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
    public static String draw(){
        String str=deck[order];
        order++;
        return str;
    }
   /* public static int value(){

    }*/

}
