package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class game1 {
    final static List<String> cards= Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    final static List<String> suits=Arrays.asList("CLUB", "DIAMOND", "SPADE", "HEART");
    final static ArrayList<String>Cards=Cards();
    final static ArrayList<String>Deck=Shuffle(Cards());
    final static ArrayList<String>player1=new ArrayList<>();
    final static ArrayList<String>player2=new ArrayList<>();
    final static ArrayList<String>player3=new ArrayList<>();
    final static ArrayList<String>communityCards=new ArrayList<>();
    static int draw=1;
   public static void main(String[] args) {
        System.out.println(Cards);
        System.out.println(Deck);
       System.out.println();
        HoleCards(player1);
        HoleCards(player2);
        HoleCards(player3);
        draw=1;
        System.out.println();
        System.out.println("Community cards");
        TheFlop(player1);
        TheFlop(player2);
        TheFlop(player3);
    }

    public static ArrayList<String> Cards() {
        ArrayList<String> Cards=new ArrayList<>();
        for (String s : cards) {
            for (String suit : suits) {
                Cards.add(s+"-"+suit);
            }
        }
        return Cards;
    }

    public static ArrayList<String> Shuffle(ArrayList<String> cards){
        Collections.shuffle(cards);
        return cards;
    }

    public static void HoleCards(ArrayList<String>player){
        player.add(Deck.get(0));
        player.add(Deck.get(1));
        System.out.println("Player:"+draw);
        System.out.println(player);
        Deck.removeAll(player);
        draw++;
    }

    public static void TheFlop(ArrayList<String>player){
        for (int i = 0; i < 3; i++) {
            communityCards.add(Deck.get(i));
        }
        player.addAll(communityCards);
        System.out.println("player"+draw);
        System.out.println(player);
        player.clear();
        communityCards.clear();
        draw++;
    }

}
