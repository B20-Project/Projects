package BlackJack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class blackJack3 {
    static int order=4;
    static String[]cards=Deck();
    static String[]deck=Shuffle(cards);
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deck));
        System.out.println("player has ");
        System.out.println(deck[0]);
        System.out.println(deck[1]);
        System.out.println();
        System.out.println();
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

}
