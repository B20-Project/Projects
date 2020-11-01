package BlackJack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class blackJack3 {
    static int order = 4;

    public static void main(String[] args) {
        String anotherGame = "";
        do {

            Scanner scan = new Scanner(System.in);
            String[] cards = Shuffle(Deck());                   //Shuffle cards
            playerMsg(cards);                                //Player's info
            dealer(cards);                                   //Dealer's info
            if (Sum(cards,0,1)[0] == 21) {
                System.out.println("Player wins");          //Blackjack
            } else {
                System.out.println("Player would you like a hit? Type 'h' if yes else 'n'");
                String hit = scan.next();
                if (hit.equals("n")) {
                    NoHit(cards);
                } else {
                    Hit(cards);
                }
            }
            System.out.println("Another game?");
            anotherGame = scan.next();

        } while (anotherGame.equals("yes"));

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

    public static void playerMsg(String[] cards) {
        System.out.println("Players card:");
        System.out.println(cards[0]);
        System.out.println(cards[1]);
        System.out.print("Player has total value of: ");
        if (Sum(cards,0,1)[1] != 0) {
            System.out.println(Sum(cards,0,1)[0] + " or " + Sum(cards,0,1)[1]);
        } else {
            System.out.println(Sum(cards,0,1)[0]);
        }
        System.out.println();
    }

    public static int[] Sum(String[] cards,int a,int b) {
        int[] sum = new int[2];
        if (cards[a].charAt(0) == 'J' || cards[a].charAt(0) == 'Q' || cards[a].charAt(0) == 'K' || cards[a].charAt(0) == '1') {
            sum[0] = 10;
        } else if (cards[a].charAt(0) == 'A') {
            sum[0] = 11;

        } else {
            sum[0] = Integer.parseInt(cards[a].substring(0, 1));
        }
        if (cards[b].charAt(0) == 'J' || cards[b].charAt(0) == 'Q' || cards[b].charAt(0) == 'K' || cards[b].charAt(0) == '1') {
            if (sum[0] == 11) {
                sum[0] = 21;
            } else {
                sum[0] += 10;
            }

        } else if (cards[b].charAt(0) == 'A') {
            if (sum[0] == 11) {
                sum[0] = 2;
            } else if (sum[0] == 10) {
                sum[0] = 21;
            } else {
                sum[0] += 11;
                sum[1] = sum[0] - 10;
            }
        } else {
            if (sum[0] == 11) {
                sum[0] += Integer.parseInt(cards[b].substring(0, 1));
                sum[1] = sum[0] - 10;
            } else {
                sum[0] += Integer.parseInt(cards[b].substring(0, 1));
            }
        }
        return sum;
    }

    public static void dealer(String[] cards) {
        String[] dealersCard = {cards[2], cards[3]};
        System.out.println("Dealers first card");
        System.out.println(dealersCard[0]);
        System.out.print("Dealer has value of:");
        if (dealersCard[0].charAt(0) == '1' || dealersCard[0].charAt(0) == 'J' || dealersCard[0].charAt(0) == 'Q' ||
                dealersCard[0].charAt(0) == 'K') {
            System.out.println(10);
        } else if (dealersCard[0].charAt(0) == 'A') {
            System.out.println(11 + " or " + 1);
        } else {
            System.out.println(Integer.parseInt(dealersCard[0].substring(0, 1)));
        }
        System.out.println();
    }

    public static void NoHit(String[] cards) {
        int sum = 0;
        String[] dealersCard = {cards[2],cards[3]};
        System.out.println("Dealers second card");
        System.out.println(dealersCard[1]);
        System.out.print("Dealer has value of:");
        if (Sum(cards,2,3)[1] != 0) {
            System.out.println(Sum(cards,2,3)[0] + " or " + Sum(cards,2,3)[1]);
        } else {
            sum = Sum(cards,2,3)[0];
            System.out.println(sum);
        }
        if (Sum(cards,2,3)[0] == 21) {
            System.out.println("Dealer wins");
            return;
        } else if (Sum(cards,2,3)[0] < 17) {
            System.out.println(cards[order]);
            if (cards[order].charAt(0) == 'A') {
                if (Sum(cards,2,3)[1] != 0) {
                    sum = Sum(cards,2,3)[0] + 1;
                } else {
                    if (Sum(cards,2,3)[0] + 11 > 21) {
                        sum = Sum(cards,2,3)[0] + 1;
                    } else {
                        sum = Sum(cards,2,3)[0] + 11;
                    }
                }
            } else if (cards[order].charAt(0) == '1' || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'K' ||
                    cards[order].charAt(0) == 'Q') {
                if (Sum(cards,2,3)[1] != 0) {
                    sum = Sum(cards,2,3)[0];
                } else {
                    sum = Sum(cards,2,3)[0] + 10;
                }
            } else {
                if (Sum(cards,2,3)[1] != 0) {
                    if (Sum(cards,2,3)[0] + Integer.parseInt(cards[order].substring(0, 1)) > 21) {
                        sum = Sum(cards,2,3)[1] + Integer.parseInt(cards[order].substring(0, 1));
                    } else {
                        sum = Sum(cards,2,3)[0] + Integer.parseInt(cards[order].substring(0, 1));
                    }
                } else {
                    sum = Sum(cards,2,3)[0] + Integer.parseInt(cards[order].substring(0, 1));
                }
            }
            System.out.println("Dealer now has " + sum);

            order++;
            if (sum < 17) {
                do {
                    System.out.println(cards[order]);
                    if (cards[order].charAt(0) == 'A') {
                        if (sum + 11 > 21) {
                            sum = sum + 1;
                        } else {
                            sum = sum + 11;
                        }
                    } else {
                        if (cards[order].charAt(0) == '1' || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'Q' ||
                                cards[order].charAt(0) == 'K') {
                            sum += 10;
                        } else {
                            sum += Integer.parseInt(cards[order].substring(0, 1));
                        }
                    }
                    System.out.println("Dealer now has " + sum);
                    order++;
                } while (sum < 17);
            }
            System.out.println();

        }
        if (sum > 21) {
            System.out.println("Player wins");
        } else if (sum == 21) {
            System.out.println("Dealer wins");
        } else if (sum > Sum(cards,0,1)[0]) {
            System.out.println("Dealer wins");
        } else if (sum < Sum(cards,0,1)[0]) {
            System.out.println("Player wins");
        } else {
            System.out.println("it's a tie");
        }

    }

    public static void Hit(String[] cards) {
        Scanner scan = new Scanner(System.in);
        String hit = "";
        int sum = 0;
        System.out.println(cards[order]);
        if (cards[order].charAt(0) == 'A') {
            if (Sum(cards,0,1)[1] != 0) {
                sum = Sum(cards,0,1)[0] + 1;
            } else {
                if (Sum(cards,0,1)[0] + 11 > 21) {
                    sum = Sum(cards,0,1)[0] + 1;
                } else {
                    sum = Sum(cards,0,1)[0] + 11;
                }
            }
        } else if (cards[order].charAt(0) == '1' || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'K' ||
                cards[order].charAt(0) == 'Q') {
            if (Sum(cards,0,1)[1] != 0) {
                sum = Sum(cards,0,1)[0];
            } else {
                sum = Sum(cards,0,1)[0] + 10;
            }
        } else {
            if (Sum(cards,0,1)[1] != 0) {
                if (Sum(cards,0,1)[0] + Integer.parseInt(cards[order].substring(0, 1)) > 21) {
                    sum = Sum(cards,0,1)[1] + Integer.parseInt(cards[order].substring(0, 1));
                } else {
                    sum = Sum(cards,0,1)[0] + Integer.parseInt(cards[order].substring(0, 1));
                }
            } else {
                sum = Sum(cards,0,1)[0] + Integer.parseInt(cards[order].substring(0, 1));
            }
        }
        if (sum > 21) {
            System.out.println(sum);
            System.out.println("Dealer wins");
        } else if (sum == 21) {
            System.out.println(sum);
            System.out.println("Player wins");
        } else {
            System.out.println("Player now has " + sum);
            order++;
            do {
                System.out.println("Would you like another hit? Type 'h' if yes else 'n");
                hit = scan.next();
                if (hit.equals("h")) {
                    System.out.println(cards[order]);
                    if (cards[order].charAt(0) == 'A') {
                        if (sum + 11 > 21) {
                            sum = sum + 1;
                        } else {
                            sum = sum + 11;
                        }
                    } else {
                        if (cards[order].charAt(0) == '1' || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'Q' ||
                                cards[order].charAt(0) == 'K') {
                            sum += 10;
                        } else {
                            sum += Integer.parseInt(cards[order].substring(0, 1));
                        }
                    }
                    System.out.println("player now has " + sum);
                    order++;
                }
            } while (hit.equals("h") && sum < 21);

            if (sum > 21) {
                System.out.println("Dealer wins");
            } else if (sum == 21) {
                System.out.println("Player wins");
            }
        }
        if (hit.equals("n")) {
            order++;
           NoHit(cards);
        }
        System.out.println();
    }
}
