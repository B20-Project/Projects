package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class game2 {
    final static List<String> cards= Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    final static List<String> suits=Arrays.asList("CLUB", "DIAMOND", "SPADE", "HEART");
    final static ArrayList<String> Cards=Cards();
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
        CommunityCards();
        TheFlop(player1);

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
    public static void CommunityCards(){
        for (int i = 0; i <3 ; i++) {
            communityCards.add(Deck.get(i));
        }
        System.out.println("Community cards:");
        System.out.println(communityCards);
    }
    public static void TheFlop(ArrayList<String>player){
        player.addAll(communityCards);
        System.out.println("player"+draw);
        System.out.println(player);
        Rank(player);
        player.clear();
        draw++;
    }
    public static void Rank(ArrayList<String>player){
        int sameCard=0;
        ArrayList<Character>eachChr=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            eachChr.add(player.get(i).charAt(0));
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j <5 ; j++) {
                if(eachChr.get(i)==eachChr.get(j)){
                    sameCard++;
                }
            }
        }
        if(sameCard>0){
            System.out.println("pair");
        }
    }



}
