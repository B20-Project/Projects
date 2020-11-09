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
    public static void CommunityCards(){
        for (int i = 0; i <3 ; i++) {
            communityCards.add(Deck.get(i));
        }
        System.out.println("Community cards:");
        System.out.println(communityCards);
        System.out.println();
    }
    public static void TheFlop(ArrayList<String>player){
        player.addAll(communityCards);
        System.out.println("player"+draw);
        System.out.println(player.get(0)+" and "+player.get(1));

        Rank(player);
        draw++;
    }
    public static void Rank(ArrayList<String>player){
        int sameCard=0;
        int[]arr=new int[2];
        int straight=0;
        boolean isStraight=false;
        int flush=0;
        ArrayList<Integer>eachNum=new ArrayList<>();
        ArrayList<String>suits=new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String value=player.get(i).substring(0,1);
            switch (value) {
                case "A" -> eachNum.add(14);
                case "2" -> eachNum.add(2);
                case "3" -> eachNum.add(3);
                case "4" -> eachNum.add(4);
                case "5" -> eachNum.add(5);
                case "6" -> eachNum.add(6);
                case "7" -> eachNum.add(7);
                case "8" -> eachNum.add(8);
                case "9" -> eachNum.add(9);
                case "1" -> eachNum.add(10);
                case "J" -> eachNum.add(11);
                case "Q" -> eachNum.add(12);
                case "K" -> eachNum.add(13);
            }
        }
        for (int i = 0; i < 5; i++) {
            if(player.get(i).contains("C")){
                suits.add("CLUB");
            }
            else if(player.get(i).contains("I")){
                suits.add("DIAMOND");
            }
            else if(player.get(i).contains("S")){
                suits.add("SPADE");
            }
            else if(player.get(i).contains("H")){
                suits.add("HEART");
            }
        }
        for (int i = 0; i < 5; i++) {
            flush=Collections.frequency(suits,suits.get(i));
            if(flush==5){
                break;
            }
        }
        boolean RoyalFlush=(eachNum.contains(10)&&eachNum.contains(11)&&eachNum.contains(12)
                &&eachNum.contains(13)&&eachNum.contains(14))&&flush==5;
        arr[0]=Collections.frequency(eachNum,eachNum.get(0));
        arr[1]=Collections.frequency(eachNum,eachNum.get(1));
        for (int i = 0; i <6 ; i++) {
            for (int j = i+1; j <player.size() ; j++) {
                if(player.get(i).equals(player.get(j))){
                    sameCard++;
                }
            }
        }
        List<Integer>sort=new ArrayList<>(eachNum);
        for (int i = 0; i < sort.size(); i++) {
            int fre = Collections.frequency(sort, sort.get(i));
            if (fre > 1) {
                sort.remove(i);
                i--;
            }
        }
        Collections.sort(sort);

            if(sort.size()>=5){
                for (int i = 0; i < sort.size()-1; i++) {
                   if(sort.get(i)==sort.get(i+1)-1){
                       straight++;
                   }
                   else{
                       straight=0;
                   }
                    if(straight>=4){
                        isStraight=true;
                    }
                }
            }
            if(RoyalFlush){
                System.out.println("Player "+draw+" has Royal flush");
            }
            else if(isStraight&&flush==5){
                System.out.println("Player "+draw+" has Straight Flush");
            }
            else if(arr[0]==4||arr[1]==4){
                System.out.println("Player "+draw+" has Four Of A Kind");
            }
            else if((communityCards.contains(player.get(0))||communityCards.contains(player.get(1)))
            &&sameCard>=4){
                System.out.println("Player "+draw+" has Full House");
            }
            else if(flush==5){
                System.out.println("Player "+draw+" Flush");
            }
            else if(isStraight){
                System.out.println("Player "+draw+" has Straight");
            }
            else if(arr[0]==3||arr[1]==3){
                System.out.println("Player " + draw + " has Three of A Kind");
            }
            else if(arr[0]==2||arr[1]==2){
                System.out.println("Player " + draw + " has One Pair");
            }
            else{
                System.out.println("Player " + draw + " has High Card");
            }
        System.out.println();



    }
}
