package BlackJack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class scratch {
    public static void main(String[] args) {
        System.out.println("Welcome to blackjack\nWould you like to play?");
        Scanner scan = new Scanner(System.in);
        String play=scan.next();
        if(play.equals("yes")) {
            String anotherGame = "";
            do {
                anotherGame = "";

                //                                                  Deck

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

                //                                          Shuffle

                Random random = new Random();
                for (int i = 0; i < cards.length; i++) {
                    int randNum = random.nextInt(52);
                    String temp = cards[randNum];
                    cards[randNum] = cards[i];
                    cards[i] = temp;
                }
                int order = 0;

                //                                              Player

                int[] sumPlayer = new int[2];
                String playersCard1 = cards[order];
                order++;
                String playersCard2 = cards[order];
                order++;
                System.out.println("Players cards:");
                System.out.println(playersCard1);
                System.out.println(playersCard2);
                if (playersCard1.charAt(0) == '1' || playersCard1.charAt(0) == 'J' || playersCard1.charAt(0) == 'K' ||
                        playersCard1.charAt(0) == 'Q') {
                    sumPlayer[0] = 10;
                } else if (Character.isDigit(playersCard1.charAt(0))) {
                    sumPlayer[0] = Integer.parseInt(playersCard1.substring(0, 1));
                } else if (playersCard1.charAt(0) == 'A') {
                    sumPlayer[0] = 11;
                    sumPlayer[1] = 1;
                }

                if (playersCard2.substring(0, 2).equals("10") || playersCard2.charAt(0) == 'J' || playersCard2.charAt(0) == 'K' ||
                        playersCard2.charAt(0) == 'Q') {
                    sumPlayer[0] += 10;
                    sumPlayer[1] += 10;
                } else if (Character.isDigit(playersCard2.charAt(0))) {
                    sumPlayer[0] += Integer.parseInt(playersCard2.substring(0, 1));
                    sumPlayer[1] += Integer.parseInt(playersCard2.substring(0, 1));
                } else if (playersCard2.charAt(0) == 'A') {
                    sumPlayer[0] += 11;
                    sumPlayer[1] += 1;
                }

                boolean playerHasA = playersCard1.charAt(0) == 'A' || playersCard2.charAt(0) == 'A';

                if (playerHasA) {
                    System.out.println("You have total of " + sumPlayer[0] + " or " + sumPlayer[1]);
                } else {
                    System.out.println("You have total of " + sumPlayer[0]);
                }
                System.out.println();


                //                                           Dealer


                String dealersCard1 = cards[order];
                order++;
                String dealersCard2 = cards[order];
                System.out.println("Dealers cards:");
                System.out.println(dealersCard1);
                System.out.println("[Hidden]");

                int[] sumDealer = new int[2];
                if (dealersCard1.substring(0, 2).equals("10") || dealersCard1.charAt(0) == 'J' || dealersCard1.charAt(0) == 'K' ||
                        dealersCard1.charAt(0) == 'Q') {
                    sumDealer[0] = 10;
                } else if (Character.isDigit(dealersCard1.charAt(0))) {
                    sumDealer[0] = Integer.parseInt(dealersCard1.substring(0, 1));
                } else if (dealersCard1.charAt(0) == 'A') {
                    sumDealer[0] = 11;
                    sumDealer[1] = 1;
                }
                if (dealersCard1.charAt(0) != 'A') {
                    System.out.println("Dealers first card is " + sumDealer[0]);
                } else {
                    System.out.println("Dealers first card is  " + sumDealer[0] + " or " + sumDealer[1]);
                }


                System.out.println();

                //                                      Player Hit false
                boolean Continue = true;
                System.out.println("Player, would you like a hit? If yes tye \'h\' if no type \'n\'");
                String hitOrNot = scan.next();
                int totalSumPlayer = 0;
                int totalSumDealer = 0;
                String sum = "";
                if (hitOrNot.equals("n")) {
                    if (playerHasA) {
                        System.out.println("Do you want " + sumPlayer[0] + " or " + sumPlayer[1] + "?");
                        do {
                            sum = "";
                            sum = scan.next();
                            if (!sum.equals(sumPlayer[0] + "") && !sum.equals(sumPlayer[1] + "")) {
                                System.out.println("Please select either " + sumPlayer[0] + " or " + sumPlayer[1]);
                            } else if (sum.equals(sumPlayer[0] + "")) {
                                totalSumPlayer = sumPlayer[0];
                            } else if (sum.equals(sumPlayer[1] + "")) {
                                totalSumPlayer = sumPlayer[1];
                            }
                        } while (!sum.equals(sumPlayer[0] + "") && !sum.equals(sumPlayer[1] + ""));
                    } else {
                        totalSumPlayer = sumPlayer[0];
                    }


                    //Need to Modify(do while)


                    System.out.println();
                    System.out.println("Dealers second card:");
                    System.out.println(dealersCard2);
                    order++;

                    if (dealersCard2.charAt(0) == '1' || dealersCard2.charAt(0) == 'J' || dealersCard2.charAt(0) == 'K' ||
                            dealersCard2.charAt(0) == 'Q') {
                        sumDealer[0] += 10;
                        sumDealer[1] += 10;
                    } else if (Character.isDigit(dealersCard2.charAt(0))) {
                        sumDealer[0] += Integer.parseInt(dealersCard2.substring(0, 1));
                        sumDealer[1] += Integer.parseInt(dealersCard2.substring(0, 1));
                    } else if (dealersCard2.charAt(0) == 'A') {
                        sumDealer[0] += 11;
                        sumDealer[1] += 1;
                    }

                    boolean dealerHasA = dealersCard1.charAt(0) == 'A' || dealersCard2.charAt(0) == 'A';

                    if (dealerHasA) {
                        System.out.println("Dealer has total of " + sumDealer[0] + " or " + (sumDealer[0] - 10));
                    } else {
                        System.out.println("Dealer has total of " + sumDealer[0]);
                    }

                    if (dealerHasA) {
                        System.out.println("Do you want " + sumDealer[0] + " or " + sumDealer[1] + "?");
                        do {
                            sum = "";
                            sum = scan.next();
                            if (!sum.equals(sumDealer[0] + "") && !sum.equals(sumDealer[1] + "")) {
                                System.out.println("Please select either " + sumDealer[0] + " or " + sumDealer[1]);
                            } else if (sum.equals(sumDealer[0] + "")) {
                                totalSumDealer = sumDealer[0];
                            } else if (sum.equals(sumDealer[1] + "")) {
                                totalSumDealer = sumDealer[1];
                            }
                        } while (!sum.equals(sumDealer[0] + "") && !sum.equals(sumDealer[1] + ""));
                    } else {
                        totalSumDealer = sumDealer[0];
                    }
                    while (totalSumDealer < 17) {
                        String hit = "";
                        System.out.println();
                        System.out.println("Type any key to hit");
                        hit = "";
                        hit = scan.next();
                        if (Character.isDigit(cards[order].charAt(0))) {
                            totalSumDealer += Integer.parseInt(cards[order].substring(0, 1));
                            System.out.println(cards[order]);
                            System.out.println("Dealer has total " + totalSumDealer);
                            order++;
                        } else if ((cards[order].substring(0, 2).equals("10") || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'K' ||
                                cards[order].charAt(0) == 'Q')) {
                            totalSumDealer += 10;
                            System.out.println(cards[order]);
                            System.out.println("Dealer has total " + totalSumDealer);
                            order++;
                        } else if (cards[order].charAt(0) == 'A') {
                            System.out.println(cards[order]);
                            System.out.println("You want the value of A 1 or 10");
                            String str = "";
                            do {
                                str = "";
                                str = scan.next();
                                if (!str.equals("1") && !str.equals("10")) {
                                    System.out.println("Please select 1 or 10");
                                } else if (str.equals("1")) {
                                    totalSumDealer += 1;
                                    System.out.println("Dealer has total " + totalSumDealer);
                                    order++;
                                } else {
                                    totalSumDealer += 10;
                                    System.out.println(cards[order]);
                                    System.out.println("Dealer has total of" + totalSumDealer);
                                    order++;
                                }

                            } while (!str.equals("1") && !str.equals("10"));
                        }
                    }
                    System.out.println();
                    if (totalSumDealer > 21) {
                        System.out.println("Player wins");
                    } else if (totalSumDealer == 21) {
                        System.out.println("Dealer wins");
                    } else if (totalSumDealer > totalSumPlayer) {
                        System.out.println("Dealer wins");
                    } else if (totalSumDealer < totalSumPlayer) {
                        System.out.println("Player wins");
                    }
                }

                //                                          Player Hit true
                else if (hitOrNot.equals("h")) {

                    System.out.println(cards[order]);
                    boolean b = (playersCard1.charAt(0) == '1' || playersCard1.charAt(0) == 'J' ||
                            playersCard1.charAt(0) == 'Q' || playersCard1.charAt(0) == 'K') || (playersCard2.charAt(0) == '1'
                            || playersCard2.charAt(0) == 'J' ||
                            playersCard2.charAt(0) == 'Q' || playersCard2.charAt(0) == 'K');
                    if (playerHasA) {
                        if (cards[order].charAt(0) == 'A') {
                            if (b) {
                                totalSumPlayer = sumPlayer[0] + 1;
                            } else {
                                if (playersCard1.charAt(0) != 'A' || playersCard2.charAt(0) != 'A') {
                                    totalSumPlayer = sumPlayer[1] + 11;
                                } else {
                                    totalSumPlayer = sumPlayer[1] + 2;
                                }
                            }
                            order++;
                        } else if (cards[order].charAt(0) == '1' || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'Q' ||
                                cards[order].charAt(0) == 'K') {
                            totalSumPlayer = sumPlayer[1] + 10;
                            order++;
                        } else {
                            int i = Integer.parseInt(cards[order].substring(0, 1));
                            if (b) {

                                totalSumPlayer = i + 11;
                            } else if (playersCard1.charAt(0) == 'A' && playersCard2.charAt(0) == 'A') {
                                totalSumPlayer = sumPlayer[1] + 2;
                            } else {
                                if (sumPlayer[1] + i > 21) {
                                    totalSumPlayer = sumPlayer[1] + i;
                                } else {
                                    totalSumPlayer = sumPlayer[0] + i;
                                }
                            }
                            order++;

                        }

                    } else if (Character.isDigit(cards[order].charAt(0)) && cards[order].charAt(0) != '1') {
                        totalSumPlayer = sumPlayer[0] + Integer.parseInt(cards[order].substring(0, 1));
                        order++;
                    } else if (cards[order].charAt(0) == 'A') {
                        if (sumPlayer[0] + 11 > 21) {
                            totalSumPlayer = sumPlayer[0] + 1;
                        } else {
                            totalSumPlayer = sumPlayer[0] + 11;
                        }
                        order++;
                    } else {
                        totalSumPlayer = sumPlayer[0] + 10;
                        order++;
                    }
                    do {
                        sum = "";
                        if (totalSumPlayer < 21) {
                            System.out.println("Player has " + totalSumPlayer);
                            System.out.println("Player, would you like another hit? If yes tye 'h' if no type 'n'");
                            sum = scan.next();
                            if (sum.equals("h")) {

                                System.out.println(cards[order]);
                                if (Character.isDigit(cards[order].charAt(0)) && cards[order].charAt(0) != '1') {
                                    totalSumPlayer += Integer.parseInt(cards[order].substring(0, 1));
                                } else if (cards[order].charAt(0) != 'A') {
                                    totalSumPlayer += 10;
                                } else if (cards[order].charAt(0) == 'A') {
                                    if (totalSumPlayer + 11 > 21) {
                                        totalSumPlayer = sumPlayer[0] + 1;
                                    } else {
                                        totalSumPlayer = totalSumPlayer + 11;
                                    }

                                }
                            }
                            order++;
                        }
                    } while (sum.equals("h"));
                    if (sum.equals("n")) {
                        order++;
                        System.out.println();
                        System.out.println("Dealers second card:");
                        System.out.println(dealersCard2);
                        order++;

                        if (dealersCard2.charAt(0) == '1' || dealersCard2.charAt(0) == 'J' || dealersCard2.charAt(0) == 'K' ||
                                dealersCard2.charAt(0) == 'Q') {
                            sumDealer[0] += 10;
                            sumDealer[1] += 10;
                        } else if (Character.isDigit(dealersCard2.charAt(0))) {
                            sumDealer[0] += Integer.parseInt(dealersCard2.substring(0, 1));
                            sumDealer[1] += Integer.parseInt(dealersCard2.substring(0, 1));
                        } else if (dealersCard2.charAt(0) == 'A') {
                            sumDealer[0] += 11;
                            sumDealer[1] += 1;
                        }

                        boolean dealerHasA = dealersCard1.charAt(0) == 'A' || dealersCard2.charAt(0) == 'A';

                        if (dealerHasA) {
                            System.out.println("Dealer has total of " + sumDealer[0] + " or " + (sumDealer[0] - 10));
                        } else {
                            System.out.println("Dealer has total of " + sumDealer[0]);
                        }

                        if (dealerHasA) {
                            System.out.println("Do you want " + sumDealer[0] + " or " + sumDealer[1] + "?");
                            do {
                                sum = "";
                                sum = scan.next();
                                if (!sum.equals(sumDealer[0] + "") && !sum.equals(sumDealer[1] + "")) {
                                    System.out.println("Please select either " + sumDealer[0] + " or " + sumDealer[1]);
                                } else if (sum.equals(sumDealer[0] + "")) {
                                    totalSumDealer = sumDealer[0];
                                } else if (sum.equals(sumDealer[1] + "")) {
                                    totalSumDealer = sumDealer[1];
                                }
                            } while (!sum.equals(sumDealer[0] + "") && !sum.equals(sumDealer[1] + ""));
                        } else {
                            totalSumDealer = sumDealer[0];
                        }
                        while (totalSumDealer < 17) {
                            String hit = "";
                            System.out.println();
                            System.out.println("Type any key to hit");
                            hit = "";
                            hit = scan.next();
                            if (Character.isDigit(cards[order].charAt(0))) {
                                totalSumDealer += Integer.parseInt(cards[order].substring(0, 1));
                                System.out.println(cards[order]);
                                System.out.println("Dealer has total " + totalSumDealer);
                                order++;
                            } else if ((cards[order].substring(0, 2).equals("10") || cards[order].charAt(0) == 'J' || cards[order].charAt(0) == 'K' ||
                                    cards[order].charAt(0) == 'Q')) {
                                totalSumDealer += 10;
                                System.out.println(cards[order]);
                                System.out.println("Dealer has total " + totalSumDealer);
                                order++;
                            } else if (cards[order].charAt(0) == 'A') {
                                System.out.println(cards[order]);
                                System.out.println("You want the value of A 1 or 10");
                                String str = "";
                                do {
                                    str = "";
                                    str = scan.next();
                                    if (!str.equals("1") && !str.equals("10")) {
                                        System.out.println("Please select 1 or 10");
                                    } else if (str.equals("1")) {
                                        totalSumDealer += 1;
                                        System.out.println("Dealer has total " + totalSumDealer);
                                        order++;
                                    } else {
                                        totalSumDealer += 10;
                                        System.out.println(cards[order]);
                                        System.out.println("Dealer has total of" + totalSumDealer);
                                        order++;
                                    }

                                } while (!str.equals("1") && !str.equals("10"));
                            }
                        }
                        System.out.println();
                        if (totalSumDealer > 21) {
                            System.out.println("Player wins");
                        } else if (totalSumDealer == 21) {
                            System.out.println("Dealer wins");
                        } else if (totalSumDealer > totalSumPlayer) {
                            System.out.println("Dealer wins");
                        } else if (totalSumDealer < totalSumPlayer) {
                            System.out.println("Player wins");
                        }

                    }
                    //
                    else if (totalSumPlayer == 21) {
                        System.out.println("Player has " + totalSumPlayer);
                        System.out.println("Player wins");
                    } else if (totalSumPlayer > 21) {
                        System.out.println("Player has " + totalSumPlayer);
                        System.out.println("Dealer wins");
                    }
                }
                System.out.println();
                System.out.println("Would you like another game?");
                anotherGame = scan.next();
            } while (anotherGame.equals("yes"));
        }
        else{
            System.out.println("Bye");
        }
    }
}


