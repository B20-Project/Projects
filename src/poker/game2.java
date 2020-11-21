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
     static ArrayList<String>RoyalFlushCards=new ArrayList<>();
     static int player1Rank;
     static int player2Rank;
     static int player3Rank;
     static int NumOfPpl=1;
     static boolean AceStraight;

     public static void main(String[] args) {
        System.out.println(Cards);
        System.out.println(Deck);
        System.out.println();
        HoleCards();
        TheFlop();
        NumOfPpl=1;
        TheRiver();
        NumOfPpl=1;
        TheTurn();
        ShowResult();
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
     public static void HoleCards(){
        PlayersFirstTwoCards(player1);
        PlayersFirstTwoCards(player2);
        PlayersFirstTwoCards(player3);
         NumOfPpl=1;
         System.out.println();
         CommunityCards(0,3);
    }
     public static void TheFlop(){
        FirstCards(player1);
        FirstCards(player2);
        FirstCards(player3);
         CommunityCards(3,4);
    }
     public static void TheRiver(){
        SecondCards(player1);
        SecondCards(player2);
        SecondCards(player3);
         CommunityCards(4,5);
    }
     public static void TheTurn(){
        ThirdCards(player1);
        ThirdCards(player2);
        ThirdCards(player3);
    }
     public static void PlayersFirstTwoCards(ArrayList<String>player){
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
     public static void FirstCards(ArrayList<String>player){
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
        AceStraight=false;
        for (int i = 0; i < player.size(); i++) {
            flush=Collections.frequency(CardSuits(player),CardSuits(player).get(i));
            if(flush>=5){
                break;
            }
        }
        boolean RoyalFlush=false;
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
            AceStraight=true;
            isStraight=true;
        }
        if(flush>=5){
            ArrayList<String>temp=new ArrayList<>(player);
            ArrayList<Integer>tempValue=new ArrayList<>(CardsValue(temp));
            ArrayList<String>tempSuit=new ArrayList<>(CardSuits(temp));
            for (int i = 0; i < temp.size(); i++) {
                if(Collections.frequency(tempSuit,tempSuit.get(i))<5){
                    temp.remove(i);
                    tempValue.remove(i);
                    tempSuit.remove(i);
                    i--;
                }
            }
            straight=0;
            ArrayList<Integer>sortTemp=new ArrayList<>(tempValue);
            for (int i = 0; i < sortTemp.size(); i++) {
                int fre = Collections.frequency(sortTemp, sortTemp.get(i));
                if (fre > 1) {
                    temp.remove(i);
                    sortTemp.remove(i);
                    i--;
                }
            }
            Collections.sort(sortTemp);
            if(sortTemp.size()>=5){
                for (int i = 0; i < sortTemp.size()-1; i++) {
                    if(sortTemp.get(i)==sortTemp.get(i+1)-1){
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
        if((CardsValue(player).contains(10)&&CardsValue(player).contains(11)&&CardsValue(player).contains(12)
                 &&CardsValue(player).contains(13)&&CardsValue(player).contains(14))){
            RoyalFlushCards=new ArrayList<>(player);
            ArrayList<Integer>tempValue=new ArrayList<>(CardsValue( RoyalFlushCards));
            ArrayList<String>tempSuits=new ArrayList<>(CardSuits( RoyalFlushCards));
            for (int i = 0; i < RoyalFlushCards.size(); i++) {
                if(tempValue.get(i)!=10||tempValue.get(i)!=11||tempValue.get(i)!=12||tempValue.get(i)!=13||
                        tempValue.get(i)!=14){
                        RoyalFlushCards.remove(i);
                        tempSuits.remove(i);
                        tempValue.remove(i);
                        i--;
                }
            }
            for (int i = 0; i < RoyalFlushCards.size(); i++) {
                if(Collections.frequency(tempSuits,tempSuits.get(i))>=5){
                    RoyalFlush=true;
                    break;
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

    }
     public static void SecondCards(ArrayList<String>player){
        player.add(Deck.get(3));
        System.out.println("player"+NumOfPpl);
        System.out.println(player);
        Rank(player);
        NumOfPpl++;
        if(player.equals(player1)){
            System.out.println(Show5Cards(player1,player1Rank));
        }
        else if(player.equals(player2)){
            System.out.println(Show5Cards(player2,player2Rank));
        }
        else{
            System.out.println(Show5Cards(player3,player3Rank));
        }
         System.out.println();
    }
     public static void ThirdCards(ArrayList<String>player){
        player.add(Deck.get(4));
        System.out.println("player"+NumOfPpl);
        System.out.println(player);
        Rank(player);
        NumOfPpl++;
         if(player.equals(player1)){
             System.out.println(Show5Cards(player1,player1Rank));
         }
         else if(player.equals(player2)){
             System.out.println(Show5Cards(player2,player2Rank));
         }
         else{
             System.out.println(Show5Cards(player3,player3Rank));
         }
         System.out.println();
    }
     public static void ShowResult(){
     ArrayList<String>players=new ArrayList<>();
     players.add("player1");
     players.add("player2");
     players.add("player3");
     ArrayList<Integer>ranks=new ArrayList<>();
     ranks.add(player1Rank);
     ranks.add(player2Rank);
     ranks.add(player3Rank);
     ArrayList<Integer>winner=new ArrayList<>();
     ArrayList<Integer>Sum=new ArrayList<>();
     int player1Sum=SumOFPlayers(CardsValue(Show5Cards(player1,player1Rank)));
     int player2Sum=SumOFPlayers(CardsValue(Show5Cards(player2,player2Rank)));
     int player3Sum=SumOFPlayers(CardsValue(Show5Cards(player3,player3Rank)));
     Sum.add(player1Sum);
     Sum.add(player2Sum);
     Sum.add(player3Sum);
     int min=Collections.min(ranks);
     int index=0;
         for (int i:ranks) {
             if(min==i){
                 winner.add(index);
             }
             index++;
         }
         System.out.println();
         if(winner.size()==1){
             int rank;
             if(players.get(winner.get(0)).contains("1")){
                 rank=player1Rank;
             }
             else if(players.get(winner.get(0)).contains("2")){
                 rank=player2Rank;
             }
             else{
                 rank=player3Rank;
             }
             System.out.println(players.get(winner.get(0))+" wins "+"with Rank "+rank);
         }
         else if(Collections.min(ranks)==8){
            pairs(players,ranks,4,8);
         }
         else if(Collections.min(ranks)==9){
          pairs(players,ranks,3,9);

         }
         else{
             ArrayList<Integer>tempSum=new ArrayList<>(Sum);
             tempSum.clear();
             for (Integer integer : winner) {
                 tempSum.add(Sum.get(integer));
             }
            int max=Collections.max(tempSum);
            if(Collections.frequency(tempSum,max)==3){
                System.out.println("Tie");
            }
            else if(Collections.frequency(tempSum,max)==2){
                int []winnerSum=new int[2];
                index=0;
                for (int i = 0; i < tempSum.size(); i++) {
                    if(tempSum.get(i)==max){
                        winnerSum[index++]=i;
                    }
                }
                System.out.println(players.get(winner.get(winnerSum[0]))+" and "+players.get(winner.get(winnerSum[1]))+" win");
            }
            else{
                int winnerSum=0;
                for (int i = 0; i < tempSum.size(); i++) {
                    if(tempSum.get(i)==max){
                        winnerSum=i;
                    }
                }
                System.out.println(players.get(winner.get(winnerSum))+" wins with higher value");
            }
         }
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
     public static ArrayList<String> Show5Cards(ArrayList<String>player,int rank){
         ArrayList<String>TempCards=new ArrayList<>(player);
        if(rank==1){
            Straight(RoyalFlushCards);
        }
        else if(rank==2){
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            ArrayList<String>suits=new ArrayList<>(CardSuits(TempCards));
            for (int i = 0; i < TempCards.size(); i++) {
                if(Collections.frequency(suits,suits.get(i))<5){
                    TempCards.remove(i);
                    suits.remove(i);
                    value.remove(i);
                    i--;
                }else if(Collections.frequency(suits,suits.get(i))<5&&Collections.frequency(value,value.get(i))>1){
                    TempCards.remove(i);
                    suits.remove(i);
                    value.remove(i);
                    i--;
                }
            }
            Straight(TempCards);
        }
        else if(rank==3){
            ArrayList<String>tempCards=new ArrayList<>(TempCards);
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            TempCards.clear();
            for (int i = 0; i < tempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))==4){
                    TempCards.add(tempCards.get(i));
                }
            }
            tempCards.removeAll(TempCards);
            TempCards.add(Sort(tempCards).get(1));
        }
        else if(rank==4){
            ArrayList<String>tempCards=new ArrayList<>(TempCards);
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            TempCards.clear();
            for (int i = 0; i < tempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))==3){
                    TempCards.add(tempCards.get(i));
                }
            }
            for (int i = 0; i < tempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))==2){
                    TempCards.add(tempCards.get(i));
                }
            }
        }
        else if(rank==5){
            ArrayList<String>suits=new ArrayList<>(CardSuits(TempCards));
            for (int i = 0; i < TempCards.size(); i++) {
                if(Collections.frequency(suits,suits.get(i))<5){
                    suits.remove(i);
                    TempCards.remove(i);
                    i--;
                }
            }
            Sort(TempCards);
            if(TempCards.size()==7){
               TempCards.remove(0);
               TempCards.remove(0);
            }
            else if(TempCards.size()==6){
                TempCards.remove(0);
            }
            Sort(TempCards);
        }
        else if(rank==6){
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            for (int i = 0; i < TempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))>1){
                    TempCards.remove(i);
                   value.remove(i);
                    i--;
                }
            }
           Sort(TempCards);
            Straight(TempCards);
        }
        else if(rank==7){
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            ArrayList<String>tempCards=new ArrayList<>(TempCards);
            TempCards.clear();
            for (int i = 0; i < tempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))>1){
                    TempCards.add(tempCards.get(i));
                }
            }
            tempCards.removeAll(TempCards);
            Sort(tempCards);
            if(player.size()==7){
                tempCards.remove(0);
                tempCards.remove(0);
                TempCards.addAll(tempCards);
            }
            else if(player.size()==6){
                tempCards.remove(0);
                TempCards.addAll(tempCards);
            }

        }
        else if(rank==8){
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            ArrayList<String>tempCards=new ArrayList<>(TempCards);
            TempCards.clear();
            for (int i = 0; i < tempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))>1){
                    TempCards.add(tempCards.get(i));
                }
            }
            Sort(TempCards);
            Collections.reverse(TempCards);
            tempCards.removeAll(TempCards);
            Sort(tempCards);
            Collections.reverse(tempCards);
            TempCards.addAll(tempCards);
            if(player.size()==7) {
                TempCards.remove(TempCards.size() - 1);
                TempCards.remove(TempCards.size() - 1);
            }else{
                TempCards.remove(TempCards.size() - 1);
            }
        }
        else if(rank==9){
            ArrayList<Integer>value=new ArrayList<>(CardsValue(TempCards));
            ArrayList<String>tempCards=new ArrayList<>(TempCards);
            TempCards.clear();
            for (int i = 0; i < tempCards.size(); i++) {
                if(Collections.frequency(value,value.get(i))>1){
                    TempCards.add(tempCards.get(i));
                }
            }
            Sort(TempCards);
            Collections.reverse(TempCards);
            tempCards.removeAll(TempCards);
            Sort(tempCards);
            Collections.reverse(tempCards);
            TempCards.addAll(tempCards);
            if(player.size()==7) {
                TempCards.remove(TempCards.size() - 1);
                TempCards.remove(TempCards.size() - 1);
            }else{
                TempCards.remove(TempCards.size() - 1);
            }
        }
        else{
            Sort(TempCards);
            if(player.size()==7) {
                TempCards.remove(0);
                TempCards.remove(0);
            }else{
                TempCards.remove(0);
            }
        }
        return TempCards;
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
         Sort(player);
         if(player.size()==7){
             if(straight==0&&AceStraight){
                 for (int i = 0; i < 2; i++) {
                     player.remove(4);
                 }
                 String temp=player.get(0);
                 player.set(0,player.get(4));
                 player.set(4,temp);
             }
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
         }
         else if(player.size()==6){
             if(straight==0&&AceStraight){
                 player.remove(4);
                 String temp=player.get(0);
                 player.set(0,player.get(4));
                 player.set(4,temp);
             }
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
         }
         for (int i = 0; i < eachNum.size(); i++) {
             if(!sort.contains(eachNum.get(i))){
                 player.remove(i);
                 eachNum.remove(i);
                 i--;
             }
         }
     }
     public static ArrayList<String> Sort(ArrayList<String>player){
         ArrayList<String>tempCards=new ArrayList<>(player);
         ArrayList<Integer>value=new ArrayList<>(CardsValue(player));
         ArrayList<Integer>sort=new ArrayList<>(value);
         Collections.sort(sort);
         player.clear();
         for (Integer integer : sort) {
             int n = value.indexOf(integer);
             player.add(tempCards.get(value.indexOf(integer)));
             value.remove(n);
             tempCards.remove(n);
         }
         return player;
     }
     public static int SumOFPlayers(ArrayList<Integer>values){
         int sum=0;
         for (int i:values) {
             sum+=i;
         }
         return sum;
     }
     public static void pairs(ArrayList<String>players,ArrayList<Integer>ranks,int index,int rank){
         ArrayList<Integer>winnerIndex=new ArrayList<>();
         ArrayList<Integer>winnerIndex1=new ArrayList<>();
         ArrayList<Integer>winnerIndex2=new ArrayList<>();
         int player1value=CardsValue(Show5Cards(player1,player1Rank)).get(0);
         int player2value=CardsValue(Show5Cards(player2,player2Rank)).get(0);
         int player3value=CardsValue(Show5Cards(player3,player3Rank)).get(0);
         int player1value2=CardsValue(Show5Cards(player1,player1Rank)).get(2);
         int player2value2=CardsValue(Show5Cards(player2,player2Rank)).get(2);
         int player3value2=CardsValue(Show5Cards(player3,player3Rank)).get(2);
         int player1value3=CardsValue(Show5Cards(player1,player1Rank)).get(index);
         int player2value3=CardsValue(Show5Cards(player2,player2Rank)).get(index);
         int player3value3=CardsValue(Show5Cards(player3,player3Rank)).get(index);
         winnerIndex.add(player1value);
         winnerIndex.add(player2value);
         winnerIndex.add(player3value);

         winnerIndex1.add(player1value2);
         winnerIndex1.add(player2value2);
         winnerIndex1.add(player3value2);

         winnerIndex2.add(player1value3);
         winnerIndex2.add(player2value3);
         winnerIndex2.add(player3value3);
         int max=Collections.max(winnerIndex);
         if(Collections.frequency(ranks,rank)==3){
             if(Collections.frequency(winnerIndex,max)==1){
                 System.out.println(players.get(winnerIndex.indexOf(max))+" wins");
             }
             else if(Collections.frequency(winnerIndex,max)==2){
                 ArrayList<Integer>Index=new ArrayList<>();
                 for (int i = 0; i < winnerIndex.size(); i++) {
                     if(winnerIndex.get(i)==max){
                         Index.add(i);
                     }
                 }
                 if(winnerIndex1.get(Index.get(0))>winnerIndex1.get(Index.get(1))){
                     System.out.println(players.get(Index.get(0))+" wins");
                 }
                 else if(winnerIndex1.get(Index.get(1))>winnerIndex1.get(Index.get(0))){
                     System.out.println(players.get(Index.get(1))+" wins");
                 }
                 else {
                     if(winnerIndex2.get(Index.get(0))>winnerIndex2.get(Index.get(0))){
                         System.out.println(players.get(Index.get(0))+" wins");
                     }
                     else if(winnerIndex2.get(Index.get(1))>winnerIndex2.get(Index.get(0))){
                         System.out.println(players.get(Index.get(1))+" wins");
                     }
                     else {
                         System.out.println(players.get(Index.get(0))+" and "+players.get(Index.get(1))+" win");
                     }
                 }
             }
             else{
                 max=Collections.max(winnerIndex1);
                 if(Collections.frequency(winnerIndex1,max)==1){
                     System.out.println(players.get(winnerIndex1.indexOf(max))+" wins");
                 }
                 else if(Collections.frequency(winnerIndex1,max)==2){
                     ArrayList<Integer>Index=new ArrayList<>();
                     for (int i = 0; i < winnerIndex1.size(); i++) {
                         if(winnerIndex1.get(i)==max){
                             Index.add(i);
                         }
                     }
                     if(winnerIndex2.get(Index.get(0))>winnerIndex2.get(Index.get(1))){
                         System.out.println(players.get(Index.get(0))+" wins");
                     }
                     else if(winnerIndex2.get(Index.get(1))>winnerIndex2.get(Index.get(0))){
                         System.out.println(players.get(Index.get(1))+" wins");
                     }
                     else {
                         System.out.println(players.get(Index.get(0))+" and "+players.get(Index.get(1))+" win");
                     }
                 }
                 else if(Collections.frequency(winnerIndex1,max)==3){
                     max=Collections.max(winnerIndex2);
                     if(Collections.frequency(winnerIndex2,max)==1){
                         System.out.println(players.get(winnerIndex2.indexOf(max))+" wins");
                     }
                     else if(Collections.frequency(winnerIndex2,max)==2){
                         ArrayList<Integer>Index=new ArrayList<>();
                         for (int i = 0; i < winnerIndex2.size(); i++) {
                             if(winnerIndex2.get(i)==max){
                                 Index.add(i);
                             }
                         }
                         System.out.println(players.get(Index.get(0))+" and "+players.get(Index.get(1)));
                     }
                     else {
                         System.out.println("Tie");
                     }
                 }
             }
         }
         else{
             ArrayList<Integer>IndexCopy=new ArrayList<>();
             int indexOF8=0;
             for (int i:ranks) {
                 if(i==rank){
                     IndexCopy.add(indexOF8);
                 }
                 else{
                     winnerIndex.set(indexOF8,0);
                     winnerIndex1.set(indexOF8,0);
                     winnerIndex2.set(indexOF8,0);
                 }
                 indexOF8++;
             }
             max=Collections.max(winnerIndex);
             if(Collections.frequency(winnerIndex,max)==1){
                 System.out.println(players.get(winnerIndex.indexOf(max))+" wins");
             }
             else if(Collections.frequency(winnerIndex,max)==2){
                 max=Collections.max(winnerIndex1);
                 if(Collections.frequency(winnerIndex1,max)==1){
                     System.out.println(players.get(winnerIndex1.indexOf(max))+ " wins");
                 }
                 else{
                     max=Collections.max(winnerIndex2);
                     if(Collections.frequency(winnerIndex2,max)==1){
                         System.out.println(players.get(winnerIndex2.indexOf(max))+" wins");
                     }
                     else{
                         System.out.println(players.get(IndexCopy.get(0))+" and "+players.get(IndexCopy.get(1))+" win");
                     }
                 }
             }
         }
     }

     }

