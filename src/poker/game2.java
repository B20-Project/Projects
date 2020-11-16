package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class game2 {
     static List<String> cards= Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
     static List<String> suits=Arrays.asList("CLUB", "DIAMOND", "SPADE", "HEART");
     static ArrayList<String> Cards=Cards();
     static ArrayList<String>Deck=Shuffle(Cards());
     static ArrayList<String>player1=new ArrayList<>();
     static ArrayList<String>player2=new ArrayList<>();
     static ArrayList<String>player3=new ArrayList<>();
     static ArrayList<String>communityCards=new ArrayList<>();
     static int player1Rank;
     static int player2Rank;
     static int player3Rank;
     static int NumOfPpl=1;
     public static void main(String[] args) {
        System.out.println(Cards);
        System.out.println(Deck);
        System.out.println();
        HoleCards(player1);
        HoleCards(player2);
        HoleCards(player3);
        NumOfPpl=1;
        System.out.println();
        CommunityCards(0,3);
        TheFlop(player1);
        TheFlop(player2);
        TheFlop(player3);
        CommunityCards(3,4);
        NumOfPpl=1;
        TheTurn(player1);
        TheTurn(player2);
        TheTurn(player3);
        ShowResult();
        CommunityCards(4,5);
        NumOfPpl=1;
        TheRiver(player1);
        TheRiver(player2);
        TheRiver(player3);
        ShowResult();
        Show5Cards(player1,player1Rank);
         Show5Cards(player2,player2Rank);
         Show5Cards(player3,player3Rank);
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
        System.out.println("Player:"+NumOfPpl);
        System.out.println(player);
        Deck.removeAll(player);
        NumOfPpl++;
    }
     public static void CommunityCards(int index1, int index2){
        for (int i = index1; i <index2 ; i++) {
            communityCards.add(Deck.get(i));
        }
        System.out.println("Community cards:");
        System.out.println(communityCards);
        System.out.println();
    }
     public static void TheFlop(ArrayList<String>player){
        player.addAll(communityCards);
        System.out.println("player"+NumOfPpl);
        System.out.println(player);
        Rank(player);
        NumOfPpl++;
    }

     public static void Rank(ArrayList<String>player){
        int Rank;
        int sameCard=0;
        int straight=0;
        boolean isStraightFlush=false;
        boolean isStraight=false;
        boolean isFourOFAKind=false;
        boolean isThreeOfAKind=false;
        boolean isPair=false;
        int flush=0;
        for (int i = 0; i < player.size(); i++) {
            flush=Collections.frequency(CardSuits(player),CardSuits(player).get(i));
            if(flush>=5){
                break;
            }
        }
        boolean RoyalFlush=(CardsValue(player).contains(10)&&CardsValue(player).contains(11)&&CardsValue(player).contains(12)
                &&CardsValue(player).contains(13)&&CardsValue(player).contains(14))&&flush==5;
         for (int i = 0; i < CardsValue(player).size(); i++) {
             if(Collections.frequency(CardsValue(player),CardsValue(player).get(i))==4){
                 isFourOFAKind=true;
             }
             else if(Collections.frequency(CardsValue(player),CardsValue(player).get(i))==3){
                 isThreeOfAKind=true;
             }
             else if(Collections.frequency(CardsValue(player),CardsValue(player).get(i))==2){
                 isPair=true;
             }
         }

        for (int i = 0; i <6 ; i++) {
            for (int j = i+1; j <CardsValue(player).size() ; j++) {
                if(CardsValue(player).get(i).equals(CardsValue(player).get(j))){
                    sameCard++;
                }
            }
        }
        List<Integer>sort=new ArrayList<>(CardsValue(player));
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
        if(CardsValue(player).contains(2)&&CardsValue(player).contains(3)&&CardsValue(player).contains(4)&&CardsValue(player).contains(5)&&CardsValue(player).contains(14)){
            isStraight=true;
        }
        if(flush>=5){
            ArrayList<String>temp=new ArrayList<>(player);
            for (int i = 0; i < temp.size(); i++) {
                if(Collections.frequency(CardSuits(temp),CardSuits(temp).get(i))<5){
                    temp.remove(i);
                    i--;
                }
            }
            straight=0;
            ArrayList<Integer>sort1=new ArrayList<>(CardsValue(temp));
            for (int i = 0; i < sort1.size(); i++) {
                int fre = Collections.frequency(sort1, sort1.get(i));
                if (fre > 1) {
                    sort1.remove(i);
                    i--;
                }
            }
            Collections.sort(sort1);
            if(sort1.size()>=5){
                for (int i = 0; i < sort1.size()-1; i++) {
                    if(sort1.get(i)==sort1.get(i+1)-1){
                        straight++;
                    }
                    else{
                        straight=0;
                    }
                    if(straight>=4){
                        isStraightFlush=true;
                    }
                }
            }

        }

            if(RoyalFlush){
                System.out.println("Player "+NumOfPpl+" has Royal flush");
                Rank =1;
            }
            else if(isStraightFlush){
                System.out.println("Player "+NumOfPpl+" has Straight Flush");
                Rank =2;
            }
            else if(isFourOFAKind){
                System.out.println("Player "+NumOfPpl+" has Four Of A Kind");
                Rank =3;
            }
            else if(isThreeOfAKind&&sameCard>=4){
                System.out.println("Player "+NumOfPpl+" has Full House");
                Rank =4;
            }
            else if(flush==5){
                System.out.println("Player "+NumOfPpl+" Flush");
                Rank =5;
            }
            else if(isStraight){
                System.out.println("Player "+NumOfPpl+" has Straight");
                Rank =6;
            }
            else if(isThreeOfAKind){
                System.out.println("Player " + NumOfPpl + " has Three of A Kind");
               Rank =7;
            }
            else if(isPair&&sameCard>=2){
                System.out.println("Player " + NumOfPpl + " Two Pair");
                Rank =8;
            }
            else if(isPair){
                System.out.println("Player " + NumOfPpl + " has One Pair");
                Rank =9;
            }

            else{
                System.out.println("Player " + NumOfPpl + " has High Card");
                Rank =10;
            }
        if(player.equals(player1)){
           player1Rank=Rank;
        }
        else if(player.equals(player2)){
            player2Rank=Rank;
        }
        else{
            player3Rank=Rank;
        }
        System.out.println();
    }
     public static void TheTurn(ArrayList<String>player){
        player.add(Deck.get(3));
        System.out.println("player"+NumOfPpl);
        System.out.println(player);
        Rank(player);
        NumOfPpl++;
    }
     public static void TheRiver(ArrayList<String>player){
        player.add(Deck.get(4));
        System.out.println("player"+NumOfPpl);
        System.out.println(player);
        Rank(player);
        NumOfPpl++;
    }
     public static void ShowResult(){
        System.out.println(player1Rank);
        System.out.println(player2Rank);
        System.out.println(player3Rank);
    }
     public static ArrayList<Integer>CardsValue(ArrayList<String>player){
         ArrayList<Integer>value=new ArrayList<>();
        for (String s:player) {
            String index1=s.substring(0,1);
            switch (index1){
                case "A" -> value.add(14);
                case "2" -> value.add(2);
                case "3" -> value.add(3);
                case "4" -> value.add(4);
                case "5" -> value.add(5);
                case "6" -> value.add(6);
                case "7" -> value.add(7);
                case "8" -> value.add(8);
                case "9" -> value.add(9);
                case "1" -> value.add(10);
                case "J" -> value.add(11);
                case "Q" -> value.add(12);
                case "K" -> value.add(13);
            }
        }
        return value;
    }
     public static ArrayList<String>CardSuits(ArrayList<String>player){
         ArrayList<String>suits=new ArrayList<>();
         for (String s : player) {
             if (s.contains("C")) {
                 suits.add("CLUB");
             } else if (s.contains("I")) {
                 suits.add("DIAMOND");
             } else if (s.contains("S")) {
                 suits.add("SPADE");
             } else if (s.contains("H")) {
                 suits.add("HEART");
             }
         }
         return suits;

     }
     public static void Show5Cards(ArrayList<String>player,int rank){
        if(rank==1){
            for (int i = 0; i <3; i++) {
                if(Collections.frequency(CardSuits(player),CardSuits(player).get(i))<5||
                        (CardsValue(player).get(i)!=10&&CardsValue(player).get(i)!=11&&
                                CardsValue(player).get(i)!=12&&CardsValue(player).get(i)!=13&&
                                CardsValue(player).get(i)!=14)){
                    player.remove(i);
                    i--;
                }
            }
            System.out.println(player);
        }
        else if(rank==6){
            for (int i = 0; i < player.size(); i++) {
                if(Collections.frequency(CardsValue(player),CardsValue(player).get(i))>1){
                    player.remove(i);
                    CardsValue(player).remove(i);
                    i--;
                }
            }
            Straight(player);
        }
     }
     public static void Straight(ArrayList<String>player){
         ArrayList<Integer>eachNum=CardsValue(player);
         ArrayList<Integer>sort=new ArrayList<>(eachNum);
         Collections.sort(sort);
         int straight=0;
         for (int i = 0; i <sort.size()-1 ; i++) {
             if(sort.get(i)==sort.get(i+1)-1){
                 straight++;
             }else{
                 if(straight>=4){
                     break;
                 }else{
                     straight=0;
                 }
             }
         }
         if(player.size()==7){
             if(straight==4){
                 if(sort.get(1)!=sort.get(2)-1){
                    sort.remove(0);
                    sort.remove(0);
                 }
                 else if(sort.get(0)!=sort.get(1)-1){
                     sort.remove(0);
                     sort.remove(sort.size()-1);
                 }else{
                     sort.remove(sort.size()-1);
                     sort.remove(sort.size()-1);
                 }
             }
             if (straight == 5) {
                 if (sort.get(0) != sort.get(1) - 1) {
                     sort.remove(0);
                     sort.remove(0);
                 } else {
                     sort.remove(0);
                     sort.remove(sort.size() - 1);
                 }
             }
             if (straight == 6) {
                 sort.remove(0);
                 sort.remove(0);
             }
             for (int i = 0; i <eachNum.size(); i++) {
                 if(!sort.contains(eachNum.get(i))){
                     player.remove(i);
                     eachNum.remove(i);
                     i--;
                 }
             }
         }
         else if(player.size()==6){
             if(straight==4){
                 if(sort.get(0)!=sort.get(1)-1){
                     sort.remove(0);
                 }
                 else{
                     sort.remove(sort.size()-1);
                 }
             }
             else if(straight==5){
                 sort.remove(0);
             }
             for (int i = 0; i < eachNum.size(); i++) {
                 if(!sort.contains(eachNum.get(i))){
                     player.remove(i);
                     eachNum.remove(i);
                     i--;
                 }
             }
         }
         System.out.println(player);

     }
}
